// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinKsp) apply false
    alias(libs.plugins.daggerHiltAndroidPlugin) apply false
    alias(libs.plugins.theRouter) apply false
//    id("cn.therouter.agp8") version "1.2.1" apply false

}
true // Needed to make the Suppress annotation work for the plugins block

