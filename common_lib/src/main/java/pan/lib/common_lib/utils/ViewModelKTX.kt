package pan.lib.common_lib.utils

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import pan.lib.common_lib.base.applicationContext
import retrofit2.HttpException

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/29
 */

fun ViewModel.http(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch {
        try {
            block()
        } catch (e: HttpException) {
            Toast.makeText(applicationContext, e.message(), Toast.LENGTH_SHORT).show()
        }
    }
}



