package pan.lib.common_lib.utils.ext

import android.content.res.Resources
import android.util.TypedValue

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/16
 */


/**
 *dp->px
 */

val Number.dp2px: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()


val Number.px2dp: Int
    get() = (this.toFloat() / Resources.getSystem().displayMetrics.density).toInt()


/**
 *sp->px
 */
val Number.sp: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()


/**
 *px->px
 */
val Number.px: Int
    get() = this.toInt()