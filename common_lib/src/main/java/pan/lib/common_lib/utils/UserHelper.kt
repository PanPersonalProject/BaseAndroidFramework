package pan.lib.common_lib.utils

import android.text.TextUtils
import pan.lib.common_lib.data.User
import pan.lib.common_lib.utils.ext.toJson
import pan.lib.common_lib.utils.ext.toObject
import javax.crypto.Cipher


/**
 *
 * Author:         pan qi
 * CreateDate:     2019/9/21 15:20
 */
object UserHelper {
    var userInfo: User? = null
        get() {
            return field ?: initUser()
        }

    private const val USER_SP_KEY = "USER_SP_KEY"


    fun saverUserInfo(user: User): Boolean {
        this.userInfo = user

        val userJson = user.toJson()
        if (TextUtils.isEmpty(userJson)) return false
        val encryptJson = DESUtil.des(userJson, Cipher.ENCRYPT_MODE)
        PreferencesUtil.setValue(USER_SP_KEY, encryptJson)
        return true
    }

    private fun initUser(): User? {
        val encryptUserJson = PreferencesUtil.getValue(USER_SP_KEY, null)
        if (TextUtils.isEmpty(encryptUserJson)) return null
        val userJson = DESUtil.des(encryptUserJson, Cipher.DECRYPT_MODE)
        userInfo = userJson.toObject()
        return userInfo
    }

    fun deleteUserInfo(): Boolean {
        return PreferencesUtil.remove(USER_SP_KEY)
    }

    fun getUserIdx(): Int {
        return userInfo?.userId ?: 0

    }

}