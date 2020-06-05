package pan.lib.common_lib.utils

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import pan.lib.common_lib.BuildConfig


/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/5 15:10
 */

private const val LOGGER_GENERAL_TAG = "TAG_GENERAL"
private const val LOGGER_NETWORK_TAG = "TAG_NETWORK"
fun initLogger() {
    val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
        .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
        .methodCount(2)         // (Optional) How many method line to show. Default 2
        .methodOffset(5)        // (Optional) Skips some method invokes in stack trace. Default 5
        .tag(LOGGER_GENERAL_TAG)
        .build()

    Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
        override fun isLoggable(priority: Int, tag: String?): Boolean {
            return BuildConfig.DEBUG
        }
    });

}

fun printNetLog(response: String?) {
    printLogWithTag(LOGGER_NETWORK_TAG, response)
}

fun printLog(any: Any) {
    Logger.d(any)
}

fun printLogWithTag(tag: String, any: Any?) {
    Logger.t(tag).d(any)

}
