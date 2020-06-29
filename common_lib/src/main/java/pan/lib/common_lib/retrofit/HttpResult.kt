package pan.lib.common_lib.retrofit

/**
 * Created by 潘琦 on 2018/8/8.
 * EMail: panqiwork@gmail.com
 */
class HttpResult<T> {
    var code = 0
    val message: String? = null
    var result: T? = null
}