package pan.lib.common_lib.utils;

import android.graphics.Color;
import android.os.Build;
import android.view.View;
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

    //设置透明状态栏
    public static void setTranslucentStatusBar(Window window) {
        if (window == null) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View decorView = window.getDecorView();
            int option = decorView.getSystemUiVisibility();
            option |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            setStatusBarColor(window, Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    //设置状态栏颜色 API>=21
    public static void setStatusBarColor(Window window, int color) {
        if (window == null) return;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(color);
        }
    }

    /**
     * 设置当前窗口亮度
     *
     * @param brightness brightness
     */
    public static void setWindowBrightness(Window window, float brightness) {
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.screenBrightness = brightness;
        window.setAttributes(lp);
    }

}
