package com.example.demo.ui.top

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.demo.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_top_article.*
import pan.lib.common_lib.base.BaseActivity

@AndroidEntryPoint
class TopArticleActivity : BaseActivity() {
    private val topArticleViewModel: TopArticleViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_article)

        initView()

        topArticleViewModel.fetchTopArticle()


    }

    private fun initView() {
        val topArticleAdapter = TopArticleAdapter()
        recyclerView.adapter = topArticleAdapter

        topArticleViewModel.articleList.observe(this, Observer {
            topArticleAdapter.setNewInstance(it)
        })
    }
}