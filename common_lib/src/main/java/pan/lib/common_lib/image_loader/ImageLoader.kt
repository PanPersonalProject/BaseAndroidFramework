package pan.lib.common_lib.image_loader

import android.content.Context
import android.graphics.Color
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.Nullable
import androidx.annotation.RawRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import pan.lib.common_lib.R

/**
 * author: Pan
 * date: 2020/6/14
 */
object ImageLoader {

    var replaceHolder: Int = Color.TRANSPARENT

    fun with(context: Context): ImageStrategy {
        return ImageStrategy(Glide.with(context))
    }

    fun with(activity: FragmentActivity): ImageStrategy {
        return ImageStrategy(Glide.with(activity))
    }

    fun with(fragment: Fragment): ImageStrategy {
        return ImageStrategy(Glide.with(fragment))
    }

    fun with(view: View): ImageStrategy {
        return ImageStrategy(Glide.with(view.context))
    }

}