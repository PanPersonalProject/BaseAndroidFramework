package pan.lib.baseandroidframework.ui.main

import android.os.Bundle
import com.example.test.activity.ExampleNetWorkActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import pan.lib.baseandroidframework.R
import pan.lib.common_lib.base.BaseActivity

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btNet.setOnClickListener {
            startActivity<ExampleNetWorkActivity>()
        }

//        requestPermission(this, Permission.Group.STORAGE,
//            {
//
//            }, {
//                toast("fail $it")
//            })
    }
}
