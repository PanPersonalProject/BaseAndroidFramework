package com.example.demo.service

import androidx.annotation.Keep
import com.tinder.scarlet.ws.Receive
import com.tinder.scarlet.ws.Send
import io.reactivex.Flowable
import com.example.demo.pojo.Protocol
import com.example.demo.pojo.Result
import com.tinder.scarlet.WebSocket

/**
 * @author pan qi
 * @since 2024/7/9
 */
@Keep
interface DemoWebsocketService {
    @Send
    fun send(protocol: Protocol)

    @Receive
    fun observeCustomInfo(): Flowable<Result>

    @Receive
    fun observeWebSocketEvent(): Flowable<WebSocket.Event>

    @Send
    fun send(msg: String)
}