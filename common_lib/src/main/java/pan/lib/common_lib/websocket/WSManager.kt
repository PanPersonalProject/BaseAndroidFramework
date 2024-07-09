package pan.lib.common_lib.websocket

import com.tinder.scarlet.Lifecycle
import com.tinder.scarlet.Scarlet
import com.tinder.scarlet.lifecycle.android.AndroidLifecycle
import com.tinder.scarlet.messageadapter.gson.GsonMessageAdapter
import com.tinder.scarlet.retry.BackoffStrategy
import com.tinder.scarlet.retry.ExponentialWithJitterBackoffStrategy
import com.tinder.scarlet.streamadapter.rxjava2.RxJava2StreamAdapterFactory
import com.tinder.scarlet.websocket.okhttp.newWebSocketFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pan.lib.common_lib.base.BaseApplication

class WSManager<Service : Any> {

    private lateinit var scarletInstance: Scarlet
    lateinit var service: Service

    /**
     * 初始化 WebSocket Manager.
     *
     * @param url WebSocket 服务器的 URL.
     * @param serviceClass 服务接口的类型.
     * @param lifecycle 可选的生命周期管理器， 默认使用 `BaseLifecycle` 实现，该实现允许 WebSocket 连接在应用进入后台时保持活跃，
     * @param backoffStrategy 重试策略，默认使用ExponentialWithJitterBackoffStrategy:有随机抖动的指数退避策略（Exponential With Jitter Backoff Strategy）.
     *                        此策略在遇到连接失败时，首先根据重试次数以指数级增加重试间隔，然后在此基础上添加随机抖动，
     *                        以进一步分散重试请求的时间点，避免大量请求同时重试造成的服务器压力，提高重连成功率。
     */
    fun init(
        url: String,
        serviceClass: Class<Service>,
        backoffStrategy: BackoffStrategy = DEFAULT_RETRY_STRATEGY,
        lifecycle: Lifecycle = DEFAULT_LIFECYCLE
    ) {

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

        scarletInstance = Scarlet.Builder()
            .webSocketFactory(okHttpClient.newWebSocketFactory(url))
            .addMessageAdapterFactory(GsonMessageAdapter.Factory())
            .addStreamAdapterFactory(RxJava2StreamAdapterFactory())
            .lifecycle(lifecycle)
            .backoffStrategy(backoffStrategy)
            .build()

        service = scarletInstance.create(serviceClass)
    }

    private companion object {
        val DEFAULT_LIFECYCLE by lazy { BaseLifecycle() }
        val APPLICATION_LIFECYCLE by lazy { AndroidLifecycle.ofApplicationForeground(BaseApplication.instance) } //默认使用应用前景生命周期，用于同步 WebSocket 连接状态与应用的生命周期.
        const val RETRY_BASE_DURATION = 1000L //起始间隔时间
        const val RETRY_MAX_DURATION = 10000L //最大间隔时间
        val DEFAULT_RETRY_STRATEGY =
            ExponentialWithJitterBackoffStrategy(RETRY_BASE_DURATION, RETRY_MAX_DURATION)
    }
}
