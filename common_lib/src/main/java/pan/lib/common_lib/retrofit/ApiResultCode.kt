package pan.lib.common_lib.retrofit

object ApiResultCode {


    const val UNKNOWN = 1000
    const val PARSE_ERROR = 1001
    const val NETWORK_NOT_CONNECTION = 1002
    const val UNKNOWN_HOST = 1003
    const val Number_Format_Exception = 1004
    const val ARGS_ERROR = 1005
    const val TOKEN_ERROR = 1006
    const val SIGN_ERROR = 1007

    /**
     * 网关错误
     */
    const val USER_INVALID = 2001
    const val SECRET_KEY_INVALID = 2002
    const val TIME_INVALID = 2003

    const val SSL_ERROR = 3001

    const val DATA_NULL = 201


}
