package pan.lib.common_lib.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView

class BottomDecoration(
    context: Context,
    @ColorInt color: Int = 0xff666666.toInt(),
    private val width: Float = 1f,
    private val startPaddingDp: Float = 0f,
    private val endPaddingDp: Float = 0f
) : RecyclerView.ItemDecoration() {

    private val paint = Paint().apply {
        this.color = color
        this.strokeWidth = width
    }

    private val startPaddingPx = context.resources.displayMetrics.density * startPaddingDp
    private val endPaddingPx = context.resources.displayMetrics.density * endPaddingDp

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val left = parent.paddingLeft + startPaddingPx
        val right = parent.width - parent.paddingRight - endPaddingPx

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = (child.bottom + params.bottomMargin).toFloat()
            val bottom = top + width

            c.drawRect(left, top, right, bottom, paint)
        }
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.set(0, 0, 0, width.toInt())
    }
}