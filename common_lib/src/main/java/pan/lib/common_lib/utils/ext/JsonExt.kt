package pan.lib.common_lib.utils.ext

import com.github.salomonbrys.kotson.fromJson
import com.google.gson.Gson

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/9 14:32
 * 扩展时参考 https://github.com/SalomonBrys/Kotson
 */
fun Any.toJson(): String = Gson().toJson(this)


inline fun <reified T : Any> String.toObject(): T = Gson().fromJson(this)

