package pan.lib.baseandroidframework.activity

import android.os.Bundle
import androidx.activity.viewModels
import kotlinx.android.synthetic.main.activity_main.*
import pan.lib.baseandroidframework.R
import pan.lib.baseandroidframework.models.TestModel
import pan.lib.common_lib.base.BaseActivity

class MainActivity : BaseActivity() {
    private val testModel by viewModels<TestModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btTest.setOnClickListener {
            testModel.testApi()

        }
    }
}
