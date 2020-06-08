package pan.lib.baseandroidframework.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.yanzhenjie.permission.runtime.Permission
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import pan.lib.baseandroidframework.R
import pan.lib.baseandroidframework.models.TestModel
import pan.lib.common_lib.base.BaseActivity
import pan.lib.common_lib.utils.requestPermission

class MainActivity : BaseActivity() {
    private val testModel by viewModels<TestModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btTest.setOnClickListener {
            testModel.testApi()

        }

        requestPermission(this, Permission.Group.STORAGE,
            {
                toast("success $it")
            }, {
                toast("fail $it")
            })
    }
}
