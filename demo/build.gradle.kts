plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinKsp)
    alias(libs.plugins.daggerHiltAndroidPlugin)
}

android {
    namespace = "com.example.demo"
    compileSdk = libs.versions.compileSdkVersion.get().toInt()


    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = true
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
    implementation(
        fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar")))
    )

    implementation(project(":common_lib"))
//    implementation(libs.baseAndroidFramework)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    ksp (libs.therouter.apt)

}