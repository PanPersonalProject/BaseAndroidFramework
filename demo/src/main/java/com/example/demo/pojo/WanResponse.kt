package com.example.demo.pojo

import pan.lib.common_lib.retrofit.Response

/**
 * author: Pan
 * date: 2020/7/12
 */
data class WanResponse<T>(val errorCode: Int, val errorMsg: String, val data: T) : Response<T> {

    override fun getCode() = errorCode


    override fun getMessage() = errorMsg


    override fun getResponse() = data


}