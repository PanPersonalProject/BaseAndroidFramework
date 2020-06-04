package pan.lib.common_lib.base

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import pan.lib.common_lib.R
import pan.lib.common_lib.utils.WindowUtil

/**
 *
 * 背景透明的 DialogFragment基类
 */
abstract class BaseDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCanceledOnTouchOutside(true)
        val window = dialog.window
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }

    val isShowing: Boolean
        get() {
            val dialog = dialog
            return dialog != null && dialog.isShowing
        }

    fun show(fragmentManager: FragmentManager?) {
        if (fragmentManager == null || isShowing) return
        val tag = this.javaClass.simpleName
        if (fragmentManager.findFragmentByTag(tag) != null) return
        fragmentManager.beginTransaction()
            .add(this, tag).commitAllowingStateLoss()
    }

    fun setGravityBottom() {
        setWindowAttr(
            Gravity.BOTTOM, WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    // 设置window属性
    fun setWindowAttr(gravity: Int, width: Int, height: Int) {
        val dialog = dialog ?: return
        // 设置宽度为屏宽, 靠近屏幕底部。
        val window = dialog.window ?: return
        WindowUtil.setWindowGravity(window, gravity)
        WindowUtil.setWindowSize(window, width, height)
        window.setWindowAnimations(R.style.Animation_CustomPopup)
    }
}