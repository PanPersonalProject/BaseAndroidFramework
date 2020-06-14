package pan.lib.common_lib.image_loader

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import java.io.File

/**
 * author: Pan
 * date: 2020/6/14
 */
class ImageStrategy(private val requestManager: RequestManager) : LoadTypes {
    lateinit var requestBuilder: RequestBuilder<Drawable>
    var replaceHolder: Int = Color.TRANSPARENT


    override fun load(bitmap: Bitmap?): ImageStrategy {
        requestBuilder = requestManager.load(bitmap)
        return this

    }

    override fun load(drawable: Drawable?): ImageStrategy {
        requestBuilder = requestManager.load(drawable)
        return this
    }

    override fun load(string: String?): ImageStrategy {
        requestBuilder = requestManager.load(string)
        return this
    }

    override fun load(uri: Uri?): ImageStrategy {
        requestBuilder = requestManager.load(uri)
        return this
    }

    override fun load(file: File?): ImageStrategy {
        requestBuilder = requestManager.load(file)
        return this
    }

    override fun load(resourceId: Int?): ImageStrategy {
        requestBuilder = requestManager.load(resourceId)
        return this
    }

    fun circle() {

    }

    fun into(imageView: ImageView) {
        requestBuilder.into(imageView)
    }


}