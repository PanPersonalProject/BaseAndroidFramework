package pan.lib.common_lib.utils.ext

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/7/9
 */

fun EditText.onTextChanged(block: (String) -> Unit) {

    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            block(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    })
}
