package pan.lib.common_lib.retrofit

import pan.lib.common_lib.data.TestBean
import retrofit2.http.GET

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/3 18:12
 */
interface ApiService {


    @GET("https://api.apiopen.top/getJoke?page=1&count=2&type=video")
    suspend fun testApi(): HttpResult<List<TestBean>>?
}