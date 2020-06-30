package com.example.test.repository

import com.example.test.TestApiService
import pan.lib.common_lib.retrofit.RetrofitManager

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/30
 */
class TestRepository {
    suspend fun testApi() = RetrofitManager.getApiService(TestApiService::class.java).testApi()
}