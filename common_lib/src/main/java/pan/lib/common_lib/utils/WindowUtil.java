package pan.lib.common_lib.utils;

import android.view.Window;
import android.view.WindowManager;

/**

 */
public class WindowUtil {

    //设置window 大小
    public static void setWindowSize(Window window, int width, int height) {
        if (window == null) return;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = width;
        attributes.height = height;
        window.setAttributes(attributes);
    }

    //设置window 重心
    public static void setWindowGravity(Window window, int gravity) {
        if (window == null) return;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = gravity;
        window.setAttributes(attributes);
    }


}
