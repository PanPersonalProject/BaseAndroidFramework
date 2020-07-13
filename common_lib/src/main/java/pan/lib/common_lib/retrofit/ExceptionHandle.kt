package pan.lib.common_lib.retrofit

import android.net.ParseException
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLException

/**
 * author: Pan
 * date: 2020/7/14
 */
object ExceptionHandle {

    fun handleException(e: Throwable?): ResultException {
        return if (e is HttpException) {
            when (e.code()) {
                UNAUTHORIZED -> ResultException(e.code(), "操作未授权")
                FORBIDDEN -> ResultException(e.code(), "请求被拒绝")
                NOT_FOUND -> ResultException(e.code(), "资源不存在")
                REQUEST_TIMEOUT -> ResultException(e.code(), "服务器执行超时")
                INTERNAL_SERVER_ERROR -> ResultException(e.code(), "服务器内部错误")
                SERVICE_UNAVAILABLE -> ResultException(e.code(), "服务器不可用")
                else -> ResultException(e.code(), "网络错误")
            }
        } else if (e is JsonParseException
            || e is JSONException
            || e is ParseException || e is MalformedJsonException
        ) {
            ResultException(PARSE_ERROR, "解析错误")
        } else if (e is ConnectException) {
            ResultException(NETWORK_ERROR, "连接失败")
        } else if (e is SSLException) {
            ResultException(SSL_ERROR, "证书验证失败")
        } else if (e is SocketTimeoutException) {
            ResultException(TIMEOUT_ERROR, "连接超时")
        } else if (e is UnknownHostException) {
            ResultException(UNKNOWN_HOST_ERROR, "主机地址未知")
        } else {
            ResultException(UNKNOWN, "未知错误")
        }
    }

    private const val UNAUTHORIZED = 401
    private const val FORBIDDEN = 403
    private const val NOT_FOUND = 404
    private const val REQUEST_TIMEOUT = 408
    private const val INTERNAL_SERVER_ERROR = 500
    private const val SERVICE_UNAVAILABLE = 503

    /**
     * 未知错误
     */
    private const val UNKNOWN = 1000

    /**
     * 解析错误
     */
    private const val PARSE_ERROR = 1001

    /**
     * 网络错误
     */
    private const val NETWORK_ERROR = 1002

    /**
     * 主机地址错误
     */
    private const val UNKNOWN_HOST_ERROR = 1003

    /**
     * 证书出错
     */
    private const val SSL_ERROR = 1005

    /**
     * 连接超时
     */
    private const val TIMEOUT_ERROR = 1006


}