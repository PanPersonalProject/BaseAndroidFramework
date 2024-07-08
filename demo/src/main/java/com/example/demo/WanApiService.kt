package com.example.demo

import com.example.demo.pojo.Article
import com.example.demo.pojo.ArticlesData
import com.example.demo.pojo.WanResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/3 18:12
 */
interface WanApiService {

    /**
     *  文章列表
     */
    @GET("article/list/{page}/json")
    suspend fun articles(
        @Path("page") page: Int
    ): WanResponse<ArticlesData>
}