package pan.lib.baseandroidframework.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import org.jetbrains.anko.startActivity
import pan.lib.baseandroidframework.databinding.ActivitySplashBinding
import pan.lib.baseandroidframework.ui.main.MainActivity
import pan.lib.common_lib.base.BaseActivity
import pan.lib.common_lib.utils.UserHelper

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showToolbar(false)
        if (UserHelper.userInfo != null) {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity<MainActivity>()
                finish()
            }, 2000)
        } else {
            startActivity<MainActivity>()
        }


    }

    override fun getLayout(layoutInflater: LayoutInflater): View {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        return binding.root
    }



}
