package pan.lib.common_lib.utils

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

val Number.dp: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    ).toInt()


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