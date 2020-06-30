package com.example.test.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.pojo.TestBean
import com.example.test.repository.TestRepository
import pan.lib.common_lib.utils.http

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/4 15:45
 */
class TestModel : ViewModel() {
    private val testRepository = TestRepository()

    val testBeanLiveData = MutableLiveData<List<TestBean>>()
    fun testApi() {
        http {
            val testBean = testRepository.testApi()
            testBeanLiveData.value = testBean?.result
        }
    }

}