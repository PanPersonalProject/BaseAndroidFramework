package pers.pan.imageloader

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * author: Pan
 * date: 2020/6/14
 */
abstract class ImageOption {
    protected var isCircle: Boolean = false
    protected var width: Int = -1
    protected var height: Int = -1
    protected var radius: Int = -1
    protected var cacheStrategyEnum: CacheStrategyEnum =
        CacheStrategyEnum.DEFAULT
    protected val transformationList = mutableListOf<Transformation<Bitmap>>()


    /**
    DiskCacheStrategy.ALL 使用DATA和RESOURCE缓存远程数据，仅使用RESOURCE来缓存本地数据。
    DiskCacheStrategy.NONE 不使用磁盘缓存
    DiskCacheStrategy.DATA 在资源解码前就将原始数据写入磁盘缓存
    DiskCacheStrategy.RESOURCE 在资源解码后将数据写入磁盘缓存，即经过缩放等转换后的图片资源。
    DiskCacheStrategy.AUTOMATIC 根据原始图片数据和资源编码策略来自动选择磁盘缓存策略。
     */
    enum class CacheStrategyEnum(val diskCacheStrategy: DiskCacheStrategy) {
        All(DiskCacheStrategy.ALL),
        NONE(DiskCacheStrategy.NONE),
        DATA(DiskCacheStrategy.DATA),
        RESOURCE(DiskCacheStrategy.RESOURCE),
        DEFAULT(DiskCacheStrategy.AUTOMATIC)
    }

    fun circle(): ImageOption {
        isCircle = true
        return this
    }

    fun radius(radius: Int): ImageOption {
        this.radius = radius
        return this
    }


    fun size(width: Int, height: Int): ImageOption {
        this.width = width
        this.height = height
        return this
    }

    fun diskCacheStrategy(cacheStrategyEnum: CacheStrategyEnum): ImageOption {
        this.cacheStrategyEnum = cacheStrategyEnum
        return this
    }


    /**
     * 用于扩展一些不常用的Transformation。换图片库，对工程改动也很小的情况下使用
     * */
    fun addTransformation(transformation: Transformation<Bitmap>) {
        transformationList.add(transformation)
    }


    abstract fun into(imageView: ImageView)

    abstract fun configTransform()

    abstract fun configCacheStrategy()

    abstract fun configSize()
}