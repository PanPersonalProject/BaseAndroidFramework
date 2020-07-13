package pan.lib.common_lib.retrofit

import android.net.ParseException
import com.google.gson.JsonParseException

import org.json.JSONException
import retrofit2.HttpException

import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.net.UnknownServiceException
import javax.net.ssl.SSLHandshakeException

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/7/13
 */
class ResultException(var errCode: Int, var msg: String?) : Exception(msg) {
    companion object {
        fun handlerException(t: Throwable): ResultException {
            val exception: ResultException
            if (t is ResultException) {
                exception = t
            } else if (t is HttpException) {
                exception = ResultException(t.code(), t.message())
            } else if (t is JsonParseException
                || t is JSONException
                || t is ParseException
            ) {
                exception = ResultException(
                    ApiResultCode.PARSE_ERROR,
                    "json解析错误:${t.message}"
                )
            } else if (t is SocketException) {
                exception = ResultException(
                    ApiResultCode.REQUEST_TIMEOUT,
                    "请求超时"
                )
            } else if (t is SocketTimeoutException) {
                exception = ResultException(
                    ApiResultCode.REQUEST_TIMEOUT,
                    t.message
                )
            } else if (t is SSLHandshakeException) {
                exception = ResultException(
                    ApiResultCode.SSL_ERROR,
                    "证书验证失败"
                )
                return exception
            } else if (t is UnknownHostException) {
                exception = ResultException(
                    ApiResultCode.UNKNOWN_HOST,
                    "网络错误，请切换网络重试"
                )
                return exception
            } else if (t is UnknownServiceException) {
                exception = ResultException(
                    ApiResultCode.UNKNOWN_HOST,
                    "网络错误，请切换网络重试"
                )
            } else if (t is NumberFormatException) {
                exception = ResultException(
                    ApiResultCode.Number_Format_Exception,
                    "数字格式化异常"
                )
            } else {
                exception = ResultException(
                    ApiResultCode.UNKNOWN,
                    "未知错误"
                )
            }
            return exception
        }

    }

}