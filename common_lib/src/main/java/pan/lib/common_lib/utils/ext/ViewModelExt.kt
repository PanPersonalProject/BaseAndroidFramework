package pan.lib.common_lib.utils.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/29
 */

fun ViewModel.launchOnUI(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch {
        block()
    }
}

fun ViewModel.launchOnIO(block: suspend CoroutineScope.() -> Unit) {
    viewModelScope.launch(Dispatchers.IO) {
        block()
    }
}


