package pan.lib.common_lib.utils

import android.content.Context
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.Permission
import com.yanzhenjie.permission.runtime.PermissionRequest

/**
 *
 * Author:         pan qi
 * CreateDate:     2020/6/8 17:54
 */

fun requestPermission(
    context: Context,
    permissionType: PermissionType,
    onGranted: (List<String>) -> Unit,
    onDenied: (List<String>) -> Unit = {}
) {
    val action = AndPermission.with(context)
        .runtime()
        .permission(permissionType.permission);
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

enum class PermissionType(val permission: Array<String>) {
    STORAGE(Permission.Group.STORAGE),
    CALENDAR(Permission.Group.CALENDAR),
    CAMERA(Permission.Group.CAMERA),
    CONTACTS(Permission.Group.CONTACTS),
    LOCATION(Permission.Group.LOCATION),
    MICROPHONE(Permission.Group.MICROPHONE),
    PHONE(Permission.Group.PHONE),
    CALL_LOG(Permission.Group.CALL_LOG),
    SENSORS(Permission.Group.SENSORS),
    ACTIVITY_RECOGNITION(Permission.Group.ACTIVITY_RECOGNITION),
    SMS(Permission.Group.SMS),

}