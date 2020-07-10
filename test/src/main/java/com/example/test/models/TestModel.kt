package com.example.test.models

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test.pojo.TestBean
import com.example.test.repository.TestRepository
import pan.lib.common_lib.utils.ext.http

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/4 15:45
 */
class TestModel @ViewModelInject constructor(private val testRepository: TestRepository)
    : ViewModel() {

    val testBeanLiveData = MutableLiveData<List<TestBean>>()
    fun testApi() {
        http {
            val testBean = testRepository.testApi()
            testBeanLiveData.value = testBean?.result
        }
    }

}