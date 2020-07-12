package com.example.demo

import com.example.demo.pojo.TopArticle
import com.example.demo.pojo.WanResponse
import retrofit2.http.GET

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/3 18:12
 */
interface WanApiService {


    /**
     *  置顶文章
     */
    @GET("/article/top/json")
    suspend fun topArticle(): WanResponse<List<TopArticle>>
}