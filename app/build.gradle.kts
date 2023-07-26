import com.example.buildsrc.Android
import com.example.buildsrc.Libs

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.composecodechallenge"
    compileSdk = Android.compileSdkVersion

    defaultConfig {
        applicationId = Android.applicationId
        minSdk = Android.minSdkVersion
        targetSdk = Android.targetSdkVersion
        versionCode = Android.versionCode
        versionName = Android.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(Libs.Jetpack.androidxCore)
    implementation (platform(Libs.Common.kotlinBom))
    implementation(Libs.Jetpack.lifecycleRuntime)
    implementation(Libs.Jetpack.activityCompose)
    implementation (platform(Libs.Jetpack.composeBom))
    implementation(Libs.Jetpack.composeUi)
    implementation(Libs.Jetpack.composeUiGraphics)
    implementation(Libs.Jetpack.composeUiToolingPreview)
    implementation(Libs.Jetpack.composeMaterial3)
    implementation(Libs.Jetpack.composeMaterial3WindowSzeClass)
    implementation(Libs.Jetpack.lifecycleRuntimeCompose)
    implementation(Libs.Jetpack.navigationCompose)
    implementation(Libs.Jetpack.trace)
    testImplementation(Libs.Testing.junit)
    androidTestImplementation(Libs.Testing.junitEx)
    androidTestImplementation(Libs.Testing.espresso)
    androidTestImplementation (platform(Libs.Jetpack.composeBom))
    androidTestImplementation(Libs.Testing.composeUiTestJunit4)
    debugImplementation(Libs.Jetpack.composeTooling)
    debugImplementation(Libs.Testing.composeUiTestManifest)
    implementation (Libs.Jetpack.workRuntime)
    //----------------------------------------------------------------------------------------------
    implementation(Libs.Jetpack.hiltAndroid)
    kapt(Libs.Jetpack.hiltAndroidCompiler)
    implementation(Libs.Jetpack.hiltWork)
    kapt(Libs.Jetpack.hiltCompiler)
    implementation(Libs.Jetpack.hiltNavCompose)
    //----------------------------------------------------------------------------------------------
    implementation(Libs.Common.stetho)
    implementation(Libs.Common.stetho_OkHttp)
    implementation(Libs.Common.okHttpInterceptor)
    //----------------------------------------------------------------------------------------------
    implementation(Libs.Common.retrofit)
    implementation(Libs.Common.retrofitGson)
    //----------------------------------------------------------------------------------------------
    implementation(Libs.Common.arrowCore)
    //----------------------------------------------------------------------------------------------
    implementation(Libs.Common.coil)
}