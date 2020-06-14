package pan.lib.baseandroidframework.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.yanzhenjie.permission.runtime.Permission
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import pan.lib.baseandroidframework.R
import pan.lib.baseandroidframework.models.TestModel
import pan.lib.common_lib.base.BaseActivity
import pan.lib.common_lib.utils.requestPermission

class MainActivity : BaseActivity() {
    private val testModel by viewModels<TestModel>()

    val picUrl =
   "https://img-blog.csdnimg.cn/20190323161242873.png"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btTest.setOnClickListener {
//            testModel.testApi()
//            ImageLoader.with(this).load(picUrl).into(imageView)
            Glide.with(this).load(picUrl).override(100,100).into(imageView)

        }

        requestPermission(this, Permission.Group.STORAGE,
            {
                toast("success $it")
            }, {
                toast("fail $it")
            })
    }
}
