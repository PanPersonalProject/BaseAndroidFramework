package pan.lib.baseandroidframework.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pan.lib.common_lib.retrofit.RetrofitManager

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/4 15:45
 */
class TestModel : ViewModel() {


    fun testApi() {
        viewModelScope.launch {
            val testApi = RetrofitManager.getApiService().testApi();
        }
    }

}