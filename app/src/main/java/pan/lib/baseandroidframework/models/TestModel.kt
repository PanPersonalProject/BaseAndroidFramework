package pan.lib.baseandroidframework.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pan.lib.common_lib.data.TestBean
import pan.lib.common_lib.retrofit.RetrofitManager
import pan.lib.common_lib.utils.http

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/4 15:45
 */
class TestModel : ViewModel() {

    val testBeanLiveData = MutableLiveData<TestBean>()
    fun testApi() {
        http {
            val testBean = RetrofitManager.getApiService().testApi()
            testBeanLiveData.value = testBean.result
        }
    }

}