package pan.lib.common_lib.websocket

import com.tinder.scarlet.WebSocket
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import io.reactivex.Flowable


interface MyWebSocketService {
    @Receive
    fun observeWebSocketEvent(): Flowable<WebSocket.Event>

    @Send
    fun send(protocol: Protocol)

    @Receive
    fun observeCustomInfo(): Flowable<Result>


    @Send
    fun send(protocol: String)
}