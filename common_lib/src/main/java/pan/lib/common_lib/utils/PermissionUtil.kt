package pan.lib.common_lib.utils

import android.content.Context
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.PermissionRequest

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/8 17:54
 */


fun requestPermission(
    context: Context,
    groups: Array<String>,
    onGranted: (List<String>) -> Unit,
    onDenied: (List<String>) -> Unit = {}
) {
    val action = AndPermission.with(context)
        .runtime()
        .permission(groups);

    startAction(action, onGranted, onDenied)

}


private fun startAction(
    action: PermissionRequest,
    onGranted: (List<String>) -> Unit,
    onDenied: (List<String>) -> Unit
) {
    action
        .onGranted {
            onGranted(it)
        }
        .onDenied {
            onDenied(it)
        }
        .start()
}