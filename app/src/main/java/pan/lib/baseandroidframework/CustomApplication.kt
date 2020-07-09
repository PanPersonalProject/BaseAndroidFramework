package pan.lib.baseandroidframework

import dagger.hilt.android.HiltAndroidApp
import pan.lib.common_lib.base.BaseApplication

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/3 15:44
 */
@HiltAndroidApp
class CustomApplication : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
    }
}