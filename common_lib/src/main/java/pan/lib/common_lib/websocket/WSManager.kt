package pan.lib.common_lib.websocket

import android.annotation.SuppressLint
import android.util.Log
import com.tinder.scarlet.Message
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.messageadapter.gson.GsonMessageAdapter
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import okhttp3.OkHttpClient

object WSManager {
    private lateinit var scarletInstance: Scarlet
    lateinit var service: MyWebSocketService


    @JvmStatic
    fun init(url: String) {
        val okHttpClient = OkHttpClient.Builder()
            .build();

        scarletInstance = Scarlet.Builder()
            .webSocketFactory(okHttpClient.newWebSocketFactory(url))
            .addMessageAdapterFactory(GsonMessageAdapter.Factory())
            .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
            .build()


        initService()
    }


    @SuppressLint("CheckResult")
    private fun initService() {
        service = scarletInstance.create<MyWebSocketService>()
        service.observeWebSocketEvent()
            .subscribe({
                when (it) {
                    is WebSocket.Event.OnConnectionOpened<*> -> {
                        Log.e(WebSocketTestServer.TAG, "WebSocket connection is opened: $it")
                    }

                    is WebSocket.Event.OnMessageReceived -> {
                        if (it.message is Message.Text) {
                            val textMessage = it.message as Message.Text
                            Log.e(WebSocketTestServer.TAG, "WebSocket text message received: ${textMessage.value}")
                        } else if (it.message is Message.Bytes) {
                            val bytesMessage = it.message as Message.Bytes
                            // 如果需要，您可以将字节数组转换为字符串
                            val text = bytesMessage.value.toString()
                            Log.e(WebSocketTestServer.TAG, "WebSocket bytes message received: $text")
                        }
                    }

                    is WebSocket.Event.OnConnectionClosing -> {
                        Log.e(WebSocketTestServer.TAG, "WebSocket connection is closing: $it")
                    }

                    is WebSocket.Event.OnConnectionClosed -> {
                        Log.e(WebSocketTestServer.TAG, "WebSocket connection is closed: $it")
                    }

                    is WebSocket.Event.OnConnectionFailed -> {
                        Log.e(WebSocketTestServer.TAG, "WebSocket connection failed: $it")
                    }
                }
            }, {
                println("WebSocket connection failed: $it")
            })

    }

}