package pan.lib.common_lib.utils
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import pan.lib.common_lib.base.applicationContext


/**
 * AUTHOR Pan Created on 2021/12/27
 */

fun makeBitmap(@DrawableRes resId: Int, width: Int): Bitmap {
    val res = applicationContext.resources
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true
    BitmapFactory.decodeResource(res, resId, options)
    options.inJustDecodeBounds = false
    options.inDensity = options.outWidth
    options.inTargetDensity = width
    return BitmapFactory.decodeResource(res, resId, options)
}

