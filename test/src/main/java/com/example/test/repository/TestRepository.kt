package com.example.test.repository

import com.example.test.TestApiService
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/30
 */

//@Singleton
class TestRepository @Inject constructor( val testApiService: TestApiService) {
    suspend fun testApi() = testApiService.testApi()
}