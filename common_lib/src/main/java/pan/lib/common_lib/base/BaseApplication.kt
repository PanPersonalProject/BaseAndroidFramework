package pan.lib.common_lib.base

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter
import com.tencent.mmkv.MMKV
import pan.lib.common_lib.BuildConfig
import pan.lib.common_lib.utils.initLogger


/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/4 16:53
 */

val applicationContext: Context
    get() = BaseApplication.instance.applicationContext

abstract class BaseApplication : MultiDexApplication() {

    companion object {
        lateinit var instance: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initLogger()
        initMMKV()
        initARouter()
    }

    private fun initMMKV() {
        MMKV.initialize(this)
    }

    private fun initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}