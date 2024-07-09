package pan.lib.common_lib.websocket

import com.tinder.scarlet.Lifecycle
import com.tinder.scarlet.lifecycle.LifecycleRegistry

/**
 * @author pan qi
 * @since 2024/7/9
 */
class BaseLifecycle(
    private val lifecycleRegistry: LifecycleRegistry = LifecycleRegistry()
) : Lifecycle by lifecycleRegistry {

    init {
        start() // 初始化时默认为 Started 状态
    }

    fun start() {
        lifecycleRegistry.onNext(Lifecycle.State.Started)
    }
    fun stop() {
        lifecycleRegistry.onNext(Lifecycle.State.Stopped.WithReason())
    }
}