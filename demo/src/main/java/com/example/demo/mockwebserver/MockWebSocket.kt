package com.example.demo.mockwebserver

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import pan.lib.common_lib.utils.ext.toJson
import pan.lib.common_lib.utils.printSimpleLog
import com.example.demo.pojo.Result

class MockWebSocket {

     val mockWebServer by lazy { MockWebServer() }

    suspend fun startMockServer() = withContext(Dispatchers.IO) {
        // Create a MockResponse to simulate the WebSocket server response
        val mockResponse = MockResponse().withWebSocketUpgrade(object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                webSocket.send("Hello, I'm WebSocket Server!")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                // Handle received message
                printSimpleLog("Server Received message From Client: $text")
                val jsonResponse = Result("I''s Server, I''m received: $text")
                    .toJson()
                webSocket.send(jsonResponse)
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                // Handle WebSocket closed
                printSimpleLog("WebSocket closed: $code - $reason")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                // Handle WebSocket failure
                printSimpleLog("WebSocket failure: ${t.message}")
            }
        })
        mockWebServer.enqueue(mockResponse)
        mockWebServer.start()
    }


    suspend fun stopMockServer() =withContext(Dispatchers.IO) {
        mockWebServer.shutdown()

    }
}
