package com.example.test.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.test.R
import kotlinx.android.synthetic.main.activity_example_net_work.*
import com.example.test.models.TestModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExampleNetWorkActivity : AppCompatActivity() {
    private val testModel: TestModel by viewModels()
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