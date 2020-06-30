package com.example.test

import com.example.test.pojo.TestBean
import pan.lib.common_lib.retrofit.HttpResult
import retrofit2.http.GET

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/3 18:12
 */
interface TestApiService {

    @GET("https://api.apiopen.top/getJoke?page=1&count=2&type=video")
    suspend fun testApi(): HttpResult<List<TestBean>>?
}