package pan.lib.common_lib.utils

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import pan.lib.common_lib.base.applicationContext

/**
 *
 * Author:         pan qi
 * CreateDate:     2019/9/7 11:10
 */

object PreferencesUtil {

    private val sharedPreferences: SharedPreferences
        get() {
            return PreferenceManager.getDefaultSharedPreferences(applicationContext)
        }

    private val editor: SharedPreferences.Editor
        get() {
            return sharedPreferences.edit()
        }


    fun getValue(key: String, defaultValue: String?): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    fun setValue(key: String, value: String?) {
        editor.putString(key, value).apply()
    }

    fun getValue(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun setValue(key: String, value: Int) {
        editor.putInt(key, value).commit()
    }

    fun getValue(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun setValue(key: String, value: Boolean) {
        editor.putBoolean(key, value).commit()
    }

    fun getValue(key: String, defaultValue: Long): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }

    fun setValue(key: String, value: Long) {
        editor.putLong(key, value).commit()
    }

    fun clear(): Boolean {
        return editor.clear().commit()
    }

    fun remove(key: String): Boolean {
        return editor.remove(key).commit()
    }
}