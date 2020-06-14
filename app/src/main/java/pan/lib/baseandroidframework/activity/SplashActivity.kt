package pan.lib.baseandroidframework.activity

import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity
import pan.lib.baseandroidframework.R
import pan.lib.common_lib.base.BaseActivity
import pan.lib.common_lib.utils.UserHelper

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
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
