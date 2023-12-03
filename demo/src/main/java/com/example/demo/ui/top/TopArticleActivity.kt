package com.example.demo.ui.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import com.example.demo.R
import com.example.demo.databinding.ActivityTopArticleBinding
import dagger.hilt.android.AndroidEntryPoint
import pan.lib.common_lib.base.BaseActivity

@AndroidEntryPoint
class TopArticleActivity : BaseActivity() {
    private val topArticleViewModel: TopArticleViewModel by viewModels()
    private lateinit var binding: ActivityTopArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(R.string.top_article)
        enableBack()
        initView()

        topArticleViewModel.fetchTopArticle()


    }

    override fun getLayout(layoutInflater: LayoutInflater): View {
        binding = ActivityTopArticleBinding.inflate(layoutInflater)
        return binding.root
    }

    private fun initView() {
        val topArticleAdapter = TopArticleAdapter()
        binding.recyclerView.adapter = topArticleAdapter

        topArticleViewModel.articleList.observe(this) {
            topArticleAdapter.setNewInstance(it)
        }
    }
}