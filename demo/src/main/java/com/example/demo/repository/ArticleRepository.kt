package com.example.demo.repository

import com.example.demo.WanApiService
import pan.lib.common_lib.base.BaseRepository
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/30
 */

@Singleton
class ArticleRepository @Inject constructor(private val wanApiService: WanApiService): BaseRepository() {
    suspend fun fetchTopArticle() = wanApiService.topArticle()
}