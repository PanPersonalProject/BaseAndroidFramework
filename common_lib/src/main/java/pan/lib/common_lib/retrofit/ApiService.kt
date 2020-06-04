package pan.lib.common_lib.retrofit

import com.google.gson.JsonObject
import pan.lib.common_lib.data.TestBean
import retrofit2.Response
import retrofit2.http.GET

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/3 18:12
 */
interface ApiService {


    @GET("https://api.gushi.ci/all.json")
    suspend fun testApi(): TestBean
}