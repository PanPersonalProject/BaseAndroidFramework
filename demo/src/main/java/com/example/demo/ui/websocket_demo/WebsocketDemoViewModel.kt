package com.example.demo.ui.websocket_demo

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo.service.DemoWebsocketService
import com.example.demo.mockwebserver.MockWebSocket
import com.tinder.scarlet.Message
import com.tinder.scarlet.WebSocket
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pan.lib.common_lib.websocket.WSManager

class WebsocketDemoViewModel : ViewModel() {
    private val websocketTag = "WebSocketTestServer"
    private val mockWebSocket = MockWebSocket()

    val receivedMessages = MutableLiveData<String>()

    private val wsManager: WSManager<DemoWebsocketService> = WSManager()
    suspend fun startWebSocketServer() {
        mockWebSocket.startMockServer()
    }

    @SuppressLint("CheckResult")
    suspend fun connectWebSocket() {
        val websocketUrl=withContext(Dispatchers.IO) {
            val mockWebServer = mockWebSocket.mockWebServer
            "ws://${mockWebServer.hostName}:${mockWebServer.port}/"
        }
        wsManager.init(websocketUrl, DemoWebsocketService::class.java)


        // 监听 WebSocket 消息
        wsManager.service.observeCustomInfo().subscribe {
            receivedMessages.postValue(it.message)
        }

        wsEventListen()

    }

    @SuppressLint("CheckResult")
    private fun wsEventListen() {
        wsManager.service.observeWebSocketEvent()
            .subscribe({
                when (it) {
                    is WebSocket.Event.OnConnectionOpened<*> -> {
                        Log.e(websocketTag, "WebSocket connection is opened: $it")
                    }

                    is WebSocket.Event.OnMessageReceived -> {
                        if (it.message is Message.Text) {
                            val textMessage = it.message as Message.Text
                            Log.e(
                                websocketTag,
                                "WebSocket text message received: ${textMessage.value}"
                            )
                        } else if (it.message is Message.Bytes) {
                            val bytesMessage = it.message as Message.Bytes
                            // 如果需要，您可以将字节数组转换为字符串
                            val text = bytesMessage.value.toString()
                            Log.e(
                                websocketTag,
                                "WebSocket bytes message received: $text"
                            )
                        }
                    }

                    is WebSocket.Event.OnConnectionClosing -> {
                        Log.e(websocketTag, "WebSocket connection is closing: $it")
                    }

                    is WebSocket.Event.OnConnectionClosed -> {
                        Log.e(websocketTag, "WebSocket connection is closed: $it")
                    }

                    is WebSocket.Event.OnConnectionFailed -> {
                        Log.e(websocketTag, "WebSocket connection failed: $it")
                    }
                }
            }, {
                println("WebSocket connection failed: $it")
            })
    }

    fun sendMessageToWebSocket(message: String) {
        wsManager.service.send(message)
    }

    fun stopWebSocketServer() {
        viewModelScope.launch {
            mockWebSocket.stopMockServer()
        }
    }

}
