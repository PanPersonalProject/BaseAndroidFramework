package pers.pan.imageloader

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import java.io.File

/**
 * author: Pan
 * date: 2020/6/14
 */

internal interface LoadTypes {

    fun load(bitmap: Bitmap?): ImageStrategy


    fun load(drawable: Drawable?): ImageStrategy


    fun load(string: String?): ImageStrategy


    fun load(uri: Uri?): ImageStrategy


    fun load(file: File?): ImageStrategy


    fun load(@RawRes @DrawableRes resourceId: Int?): ImageStrategy

}
