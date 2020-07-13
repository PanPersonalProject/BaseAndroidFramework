package pan.lib.common_lib.retrofit

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/7/13
 */
class ResultException(var errCode: Int, var msg: String?) : Exception(msg)