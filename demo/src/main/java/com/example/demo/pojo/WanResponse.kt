package com.example.demo.pojo

/**
 * author: Pan
 * date: 2020/7/12
 */
data class WanResponse<T>(val errorCode: Int, val errorMsg: String, val data: T)