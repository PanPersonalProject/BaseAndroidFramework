package pan.lib.baseandroidframework.ui

import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jetbrains.anko.startActivity
import pan.lib.baseandroidframework.R
import pan.lib.baseandroidframework.ui.main.MainActivity
import pan.lib.common_lib.base.BaseActivity
import pan.lib.common_lib.utils.UserHelper

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
       GlobalScope.launch (Dispatchers.Main){  }
        if (UserHelper.userInfo != null) {
            Handler().postDelayed({
                startActivity<MainActivity>()
                finish()
            }, 2000)
        } else {
            //todo go to login activity
            startActivity<MainActivity>()
        }


    }


}
