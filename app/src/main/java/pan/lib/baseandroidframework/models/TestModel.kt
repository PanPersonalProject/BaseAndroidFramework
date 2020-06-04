package pan.lib.baseandroidframework.models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hjq.toast.ToastUtils
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
            Log.i("ppp",testApi.toString())

        }
    }

}