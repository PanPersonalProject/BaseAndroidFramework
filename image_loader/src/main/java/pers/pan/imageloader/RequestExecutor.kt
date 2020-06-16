package pers.pan.imageloader

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/16
 */
@SuppressLint("CheckResult")
class RequestExecutor(private val requestBuilder: RequestBuilder<Drawable>) : ImageOption() {
    private val requestOptions = RequestOptions()

    override fun into(imageView: ImageView) {

        configSize()

        configCacheStrategy()

        configTransform()

        requestBuilder.apply(requestOptions).into(imageView)
    }

    override fun configTransform() {

        if (isCircle) {
            transformationList.add(CircleCrop())
        } else if (radius > 0) {
            transformationList.add(RoundedCornersTransformation(radius, 0))
        }


        val multi = MultiTransformation(transformationList)
        requestOptions.apply(RequestOptions.bitmapTransform(multi))

    }

    override fun configCacheStrategy() {
        requestOptions.diskCacheStrategy(cacheStrategyEnum.diskCacheStrategy)
    }

    override fun configSize() {
        if (width > 0 && height > 0) {
            requestOptions.override(width, height)
        }
    }


}