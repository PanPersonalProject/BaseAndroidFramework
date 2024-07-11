package com.example.demo.repository

import com.example.demo.service.WanApiService
import com.example.demo.pojo.ArticlesData
import pan.lib.common_lib.base.BaseRepository
import pan.lib.common_lib.retrofit.NetResult
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/30
 */

@Singleton
class ArticleRepository @Inject constructor(private val wanApiService: WanApiService) :
    BaseRepository() {
    suspend fun fetchTopArticle(): NetResult<ArticlesData> {
        return fetchApi { wanApiService.articles(0) }
    }

}