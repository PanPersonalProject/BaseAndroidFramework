package com.example.demo.ui.top

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.pojo.TopArticle
import com.example.demo.repository.ArticleRepository
import pan.lib.common_lib.utils.ext.http

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/4 15:45
 */
class TopArticleViewModel @ViewModelInject constructor(private val articleRepository: ArticleRepository) :
    ViewModel() {


    val articleList = MutableLiveData<MutableList<TopArticle>>()

    fun fetchTopArticle() {
        http {
            val response = articleRepository.fetchTopArticle()
            articleList.value = response.data.toMutableList()
        }
    }

}