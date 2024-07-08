package com.example.demo.pojo

/**
 * @author pan qi
 * @since 2024/7/8
 */
data class ArticlesData(
    val curPage: Int,
    val datas: List<Article>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)