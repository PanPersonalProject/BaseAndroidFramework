package pan.lib.common_lib.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ImmersionBar
import kotlinx.android.synthetic.main.activity_base.*
import pan.lib.common_lib.R

abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        LayoutInflater.from(this).inflate(getLayoutId(), viewContent)
        initStatusBar()
        initToolbar()

    }

    private fun initToolbar() {
        setSupportActionBar(commonToolbar);
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }


    abstract fun getLayoutId(): Int

    open fun initStatusBar() {
        ImmersionBar.with(this)
            .statusBarColor(R.color.colorPrimary)
            .keyboardEnable(true)  //解决软键盘与底部输入框冲突问题
            .init();
    }

    /**
     * 设置标题
     * @param title
     */
    fun setTitle(title: String?) {
        tvTitle.text = title

    }

    /**
     * 设置标题
     * @param resId
     */
    override fun setTitle(@StringRes resId: Int) {
        tvTitle.setText(resId)
    }

    fun enableBack() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)//左侧添加一个默认的返回图标
        supportActionBar?.setDisplayShowHomeEnabled(true)//设置返回键可用
        commonToolbar.setNavigationOnClickListener { finish() }
    }


    open fun showToolbar(isShowing: Boolean) {
        commonToolbar.visibility = if (isShowing) View.VISIBLE else View.GONE
    }
}
