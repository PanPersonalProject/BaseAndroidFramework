package pan.lib.common_lib.retrofit

/**
 * Created by 潘琦 on 2018/8/8.
 * EMail: panqiwork@gmail.com
 */
data class HttpResult<T>(val errorCode: Int, val errorMsg: String, val data: T)