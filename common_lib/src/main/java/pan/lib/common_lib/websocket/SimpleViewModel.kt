package pan.lib.common_lib.websocket

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData

@SuppressLint("CheckResult")
class SimpleViewModel {
    var signInfo = MutableLiveData<Result>()

    init {
//        .compose(Transformers.flowableAdapter())

        WSManager.service.observeCustomInfo()
            .subscribe { value: Result -> signInfo.postValue(value) }
    }

}