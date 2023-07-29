import com.example.buildsrc.Libs
import com.example.buildsrc.Android

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.domain"
    compileSdk = Android.compileSdkVersion

    defaultConfig {
        minSdk = Android.minSdkVersion
        targetSdk = Android.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
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
    implementation(Libs.Jetpack.hiltAndroid)
    kapt(Libs.Jetpack.hiltAndroidCompiler)
    implementation(Libs.Common.gson)
    implementation(Libs.Common.arrowCore)
    implementation(Libs.Common.retrofit)
    testImplementation(Libs.Testing.junit)
    testImplementation(Libs.Testing.mockitoKotlin)
}