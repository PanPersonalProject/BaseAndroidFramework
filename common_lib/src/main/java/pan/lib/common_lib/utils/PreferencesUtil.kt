package pan.lib.common_lib.utils

import android.os.Parcelable
import com.tencent.mmkv.MMKV
import java.util.*

/**
 *
 * Author:         pan qi
 * CreateDate:     2019/9/7 11:10
 */

object PreferencesUtil {

    private val kv: MMKV?
        get() {
            return MMKV.defaultMMKV()
        }


    fun put(key: String, value: Any?) {
        when (value) {
            is String -> kv?.encode(key, value)
            is Float -> kv?.encode(key, value)
            is Boolean -> kv?.encode(key, value)
            is Int -> kv?.encode(key, value)
            is Long -> kv?.encode(key, value)
            is Double -> kv?.encode(key, value)
            is ByteArray -> kv?.encode(key, value)
            else -> return
        }
    }

    fun <T : Parcelable> put(key: String, t: T?) {
        if (t == null) {
            return
        }
        kv?.encode(key, t)
    }

    fun put(key: String, sets: Set<String>?) {
        if (sets == null) {
            return
        }
        kv?.encode(key, sets)
    }

    fun <T : Parcelable> getParcelable(key: String, tClass: Class<T>): T? {
        return kv?.decodeParcelable(key, tClass)
    }

    fun getString(key: String, defaultValue: String? = null): String? {
        return kv?.decodeString(key, defaultValue)
    }

    fun getInt(key: String, defaultValue: Int = 0): Int? {
        return kv?.decodeInt(key, 0)
    }

    fun getDouble(key: String, defaultValue: Double = 0.0): Double? {

        return kv?.decodeDouble(key, defaultValue)
    }

    fun getLong(key: String, defaultValue: Long = 0L): Long? {
        return kv?.decodeLong(key, defaultValue)
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean? {
        return kv?.decodeBool(key, defaultValue)
    }

    fun getFloat(key: String, defaultValue: Float = 0.0f): Float? {
        return kv?.decodeFloat(key, defaultValue)
    }

    fun getByteArray(key: String): ByteArray? {
        return kv?.decodeBytes(key)
    }


    fun getStringSet(key: String): Set<String>? {
        return kv?.decodeStringSet(key, Collections.emptySet())
    }

    fun clear() {
        kv?.clearAll()
    }

    fun remove(key: String) {
        kv?.removeValueForKey(key)
    }
}


