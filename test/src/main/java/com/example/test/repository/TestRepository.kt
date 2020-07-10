package com.example.test.repository

import com.example.test.TestApiService
import pan.lib.common_lib.base.BaseRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/30
 */

@Singleton
class TestRepository @Inject constructor(private val testApiService: TestApiService): BaseRepository() {
    suspend fun testApi() = testApiService.testApi()
}