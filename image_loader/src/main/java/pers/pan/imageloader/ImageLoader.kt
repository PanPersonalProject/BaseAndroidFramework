package pers.pan.imageloader

import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide

/**
 * author: Pan
 * date: 2020/6/14
 * 图片加载二次封装，方便统一管理和替换
 */
object ImageLoader {

    var replaceHolder: Int = Color.TRANSPARENT

    fun with(context: Context): RequestManager {
        return RequestManager(Glide.with(context))
    }

    fun with(activity: FragmentActivity): RequestManager {
        return RequestManager(Glide.with(activity))
    }

    fun with(fragment: Fragment): RequestManager {
        return RequestManager(Glide.with(fragment))
    }

    fun with(view: View): RequestManager {
        return RequestManager(Glide.with(view.context))
    }

}