package com.example.demo.ui.top

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.test.R
import kotlinx.android.synthetic.main.activity_example_net_work.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopArticleActivity : AppCompatActivity() {
    private val topArticleViewModel: TopArticleViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_net_work)

        btTest.setOnClickListener {
            topArticleViewModel.testApi()
        }

        topArticleViewModel.articleList.observe(this, Observer {
            tvText.text = it.toString()
        })
    }
}