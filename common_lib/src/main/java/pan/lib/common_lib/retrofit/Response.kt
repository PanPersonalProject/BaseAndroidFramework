package pan.lib.common_lib.retrofit

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/7/13
 * 适配多种格式的Response
 */
interface Response<T> {
    fun getCode(): Int
    fun getMessage(): String
    fun getResponse(): T
}