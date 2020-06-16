package pers.pan.imageloader

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import java.io.File

/**
 * author: Pan
 * date: 2020/6/14
 */
class RequestManager(private val requestManager: RequestManager) : LoadTypes {
    lateinit var requestBuilder: RequestBuilder<Drawable>
    var replaceHolder: Int = Color.TRANSPARENT


    override fun load(bitmap: Bitmap?): RequestExecutor {
        requestBuilder = requestManager.load(bitmap)
        return RequestExecutor(requestBuilder)
    }

    override fun load(drawable: Drawable?): RequestExecutor {
        requestBuilder = requestManager.load(drawable)
        return RequestExecutor(requestBuilder)
    }

    override fun load(string: String?): RequestExecutor {
        requestBuilder = requestManager.load(string)
        return RequestExecutor(requestBuilder)
    }

    override fun load(uri: Uri?): RequestExecutor {
        requestBuilder = requestManager.load(uri)
        return RequestExecutor(requestBuilder)
    }

    override fun load(file: File?): RequestExecutor {
        requestBuilder = requestManager.load(file)
        return RequestExecutor(requestBuilder)
    }

    override fun load(resourceId: Int?): RequestExecutor {
        requestBuilder = requestManager.load(resourceId)
        return RequestExecutor(requestBuilder)
    }


}