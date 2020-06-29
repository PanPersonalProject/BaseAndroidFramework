package com.example.test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.test.R
import kotlinx.android.synthetic.main.activity_example_net_work.*
import pan.lib.baseandroidframework.models.TestModel

class ExampleNetWorkActivity : AppCompatActivity() {
    private val testModel by viewModels<TestModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_net_work)

        btTest.setOnClickListener {
            testModel.testApi()
        }

        testModel.testBeanLiveData.observe(this, Observer {
            tvText.text = it.toString()
        })
    }
}