package pan.lib.common_lib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import pan.lib.common_lib.R

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStatusBar()
    }


    open fun initStatusBar() {
        ImmersionBar.with(this)
            .statusBarColor(R.color.colorPrimary)
            .keyboardEnable(true)  //解决软键盘与底部输入框冲突问题
            .init();
    }


}
