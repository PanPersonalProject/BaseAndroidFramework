package com.example.test.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.TestApiService
import com.example.test.pojo.TestBean
import pan.lib.common_lib.retrofit.RetrofitManager
import pan.lib.common_lib.utils.http

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/4 15:45
 */
class TestModel : ViewModel() {

    val testBeanLiveData = MutableLiveData<List<TestBean>>()
    fun testApi() {
        http {
            val testBean = RetrofitManager.getApiService(TestApiService::class.java).testApi()
            testBeanLiveData.value = testBean?.result
        }
    }

}