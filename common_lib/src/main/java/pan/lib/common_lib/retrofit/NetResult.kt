package pan.lib.common_lib.retrofit

/**
 * author: Pan
 * date: 2020/7/13
 */
sealed class NetResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : NetResult<T>()
    data class Error(val exception: ResultException) : NetResult<Nothing>()


    fun whenSuccess(block: (T) -> Unit) {
        if (this is Success<T>) {
            block(this.data)
        }
    }


    fun whenFailure(block: (Error) -> Unit) {
        if (this is Error) {
            block(this)
        }
    }


    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }

}