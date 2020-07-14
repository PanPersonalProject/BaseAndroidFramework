package pan.lib.login.data

import pan.lib.common_lib.retrofit.NetResult
import pan.lib.common_lib.retrofit.ResultException
import pan.lib.login.data.model.LoggedInUser
import javax.inject.Inject

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource @Inject constructor() {

    fun login(username: String, password: String): NetResult<LoggedInUser> {
        return try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            NetResult.Success(fakeUser)
        } catch (e: Throwable) {
            NetResult.Error(ResultException(1000, "Error logging in"))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}