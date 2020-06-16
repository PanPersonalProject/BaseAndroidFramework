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

    fun load(bitmap: Bitmap?): RequestExecutor


    fun load(drawable: Drawable?): RequestExecutor


    fun load(string: String?): RequestExecutor


    fun load(uri: Uri?): RequestExecutor


    fun load(file: File?): RequestExecutor


    fun load(@RawRes @DrawableRes resourceId: Int?): RequestExecutor

}
