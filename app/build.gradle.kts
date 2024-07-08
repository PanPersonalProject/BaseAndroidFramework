plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinKsp)
    alias(libs.plugins.daggerHiltAndroidPlugin)
    id ("therouter")
}
android {
    namespace = "pan.lib.baseandroidframework"

    compileSdk = libs.versions.compileSdkVersion.get().toInt()

    defaultConfig {
        applicationId = "pan.lib.baseandroidframework"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        ndk {
            abiFilters.add("arm64-v8a")
        }

    }

    signingConfigs {
        create("jks") {
            storeFile = file("key.jks")
            storePassword = "yesterday you said tomorrow"
            keyAlias = "key"
            keyPassword = "yesterday you said tomorrow"
        }
    }
    buildFeatures {
        viewBinding = true
    }
    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("jks")
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            signingConfig = signingConfigs.getByName("jks")
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    hilt {
        enableAggregatingTask = false
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":demo"))

    implementation(project(":common_lib"))
//    implementation(libs.baseAndroidFramework)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    ksp (libs.therouter.apt)
}
