plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinKsp)
    alias(libs.plugins.daggerHiltAndroidPlugin)
    id("org.jetbrains.kotlin.kapt")
    id("maven-publish")
}


android {
    namespace = "pan.lib.common_lib"
    compileSdk = libs.versions.compileSdkVersion.get().toInt()


    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        consumerProguardFiles("consumer-rules.pro")

    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

}

dependencies {
    api(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(libs.material)
    api(libs.androidx.annotation)
    api(libs.androidx.lifecycle.extensions)
    api(libs.androidx.core.ktx)
    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.androidx.fragment.ktx)
    api(libs.org.jetbrains.kotlinx.coroutines.core)
    api(libs.org.jetbrains.anko)
    api(libs.androidx.appcompat)
    api(libs.androidx.constraintlayout)
    api(libs.androidx.multidex)
    api(libs.androidx.preference.ktx)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    // Third-party libraries
    api(libs.glide)
    ksp(libs.glide.ksp)
    api(libs.glide.transformations)
    api(libs.com.google.gson)
    api(libs.com.github.salomonbrys.kotson)
    api(libs.org.greenrobot.eventbus)
    api(libs.baseRecyclerViewAdapterHelper)
    api(libs.com.yanyusong.y.divideritemdecoration)
    api(libs.com.yanzhenjie.permission)
    api(libs.com.squareup.retrofit2.retrofit)
    api(libs.com.squareup.retrofit2.converter.gson)
    api(libs.com.squareup.okhttp3.logging.interceptor)
    api(libs.com.hjq.toast)
    api(libs.com.orhanobut.logger)
    api(libs.arouter.api)
    api(libs.com.gyf.immersionbar)
    implementation(libs.com.tencent.mmkv.static)

    implementation(libs.com.squareup.okhttp3)
    implementation(libs.com.squareup.okhttp3.mockwebserver)
    implementation(libs.com.tinder.scarlet)
    implementation(libs.com.tinder.scarlet.websocket.okhttp)
    implementation(libs.com.tinder.scarlet.message.adapter.gson)
    implementation(libs.com.tinder.scarlet.stream.adapter.rxjava2)
}

// 注意 这边配置的groupId artifactId version 实际测试只对本地mavenLocal生效
// jitpack点击发布貌似不会采纳 而是 根据 com.github.userName:projectName:Tag的格式
// 因此 本地配置的版本和远程配置的版本请完全对应 (本段内容也不能丢失) 貌似的原理是github在远端服务器 的mavenLocal
// 生成文件 然后映射相关文件 到 指定的格式

//publishing { // 发布配置
//    publications { // 发布的内容
//        register<MavenPublication>("release") { // 注册一个名字为 release 的发布内容
//            groupId = "com.github.PanPersonalProject"
//            artifactId = "common_lib"
//            version = "V1.0.0-SNAPSHOT"
//
//            afterEvaluate { // 在所有的配置都完成之后执行
//                // 从当前 module 的 release 包中发布
//                from(components["release"])
//            }
//        }
//    }
//}