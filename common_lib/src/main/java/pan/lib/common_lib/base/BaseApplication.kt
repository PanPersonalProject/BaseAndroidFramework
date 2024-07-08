package pan.lib.common_lib.base

import android.content.Context
import androidx.multidex.MultiDexApplication
import com.tencent.mmkv.MMKV
import com.therouter.TheRouter
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
    }

    override fun attachBaseContext(base: Context?) {
        TheRouter.isDebug=true
        super.attachBaseContext(base)
    }

    private fun initMMKV() {
        MMKV.initialize(this)
    }


}