package pan.lib.common_lib.base

import pan.lib.common_lib.retrofit.NetResult
import pan.lib.common_lib.retrofit.Response
import pan.lib.common_lib.retrofit.ResultException

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/7/10
 */
open class BaseRepository {

    protected suspend fun <T : Any> checkResponse(response: Response<T>): NetResult<T> {
        return if (response.getCode() == 0) {
            NetResult.Success(response.getResponse())
        } else {
            NetResult.Error(
                ResultException(
                    response.getCode(),
                    response.getMessage()
                )
            )
        }
    }

}