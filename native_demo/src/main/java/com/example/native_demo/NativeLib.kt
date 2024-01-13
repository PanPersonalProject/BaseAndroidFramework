package com.example.native_demo

class NativeLib {

    /**
     * A native method that is implemented by the 'native_demo' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'native_demo' library on application startup.
        init {
            System.loadLibrary("native_demo")
        }
    }
}