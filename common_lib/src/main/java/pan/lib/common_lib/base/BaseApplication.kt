package pan.lib.common_lib.base

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.hjq.toast.ToastUtils

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/4 16:53
 */

abstract class BaseApplication : MultiDexApplication() {

    companion object {
        var instance: BaseApplication? = null

        fun getContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}