package pan.lib.common_lib.views

import android.content.Context
import androidx.annotation.ColorInt
import com.yanyusong.y_divideritemdecoration.Y_Divider
import com.yanyusong.y_divideritemdecoration.Y_DividerBuilder
import com.yanyusong.y_divideritemdecoration.Y_DividerItemDecoration

class BottomDecoration(
    context: Context,
    @ColorInt color: Int = 0xff666666.toInt(),
    width: Float = 1f,
    startPaddingDp: Float = 0f,
    endPaddingDp: Float = 0f
) :
    Y_DividerItemDecoration(context) {

    private var divider: Y_Divider = Y_DividerBuilder()
        .setBottomSideLine(true, color, width, startPaddingDp, endPaddingDp)
        .create()

    override fun getDivider(itemPosition: Int): Y_Divider {
        return divider
    }
}