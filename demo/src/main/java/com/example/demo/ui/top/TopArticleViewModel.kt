package com.example.demo.ui.top

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demo.pojo.TopArticle
import com.example.demo.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import pan.lib.common_lib.utils.ext.launchOnUI
import javax.inject.Inject

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/4 15:45
 */
@HiltViewModel
class TopArticleViewModel @Inject constructor(private val articleRepository: ArticleRepository) :
    ViewModel() {


    val articleList = MutableLiveData<MutableList<TopArticle>>()

    fun fetchTopArticle() {
        launchOnUI {
            val response = articleRepository.fetchTopArticle()

            response.whenSuccess {
                articleList.value = it.toMutableList()
            }

        }
    }

}