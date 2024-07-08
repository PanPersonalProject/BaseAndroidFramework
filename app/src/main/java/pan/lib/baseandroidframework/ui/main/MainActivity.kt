package pan.lib.baseandroidframework.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.therouter.TheRouter
import pan.lib.baseandroidframework.databinding.ActivityMainBinding
import pan.lib.common_lib.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTitle("首页")
        binding.btNet.setOnClickListener {
            TheRouter.build("/demo/TopArticleActivity")
                .navigation(this)
        }
    }


    override fun getLayout(layoutInflater: LayoutInflater): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

}
