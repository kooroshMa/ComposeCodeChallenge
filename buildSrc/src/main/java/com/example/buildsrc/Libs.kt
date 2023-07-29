package com.example.buildsrc

object Libs {

    object Modules {
        const val domain = ":core:domain"
        const val data = ":core:data"
    }

    object Jetpack {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid}"
        const val hiltAndroidCompiler =
            "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroid}"
        const val hiltWork = "androidx.hilt:hilt-work:${Versions.hiltWork}"
        const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
        const val hiltNavCompose =
            "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.arch}"
        const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
        const val trace = "androidx.tracing:tracing-ktx:${Versions.trace}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
        //---compose boms--
        const val composeBom = "androidx.compose:compose-bom:${Versions.composeBom}"
        const val composeUi = "androidx.compose.ui:ui"
        const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
        const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val composeMaterial3 = "androidx.compose.material3:material3"
        const val composeTooling = "androidx.compose.ui:ui-tooling"
        const val composeMaterial3WindowSzeClass = "androidx.compose.material3:material3-window-size-class"
        const val lifecycleRuntimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleRuntimeCompose}"
        const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"
        const val workRuntime = "androidx.work:work-runtime-ktx:${Versions.workRuntime}"
    }

    object Common {
        const val kotlinBom = "org.jetbrains.kotlin:kotlin-bom:1.9.0"
        const val gson = "com.google.code.gson:gson:${Versions.gson}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
        const val stetho = "com.facebook.stetho:stetho:${Versions.stetho}"
        const val stetho_OkHttp = "com.facebook.stetho:stetho-okhttp3:${Versions.stetho}"
        const val arrowCore = "io.arrow-kt:arrow-core:${Versions.arrow}"
        const val coil = "io.coil-kt:coil-compose:${Versions.coil}"
        const val material = "com.google.android.material:material:${Versions.material}"
    }

    object Testing {
        const val junit = "junit:junit:${Versions.junit}"
        const val junitEx = "androidx.test.ext:junit:${Versions.junitEx}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"

        //----------
        const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"
        const val composeUiTestJunit4 = "androidx.compose.ui:ui-test-junit4"
        //----------
        const val uiAnimatorTest = "androidx.test.uiautomator:uiautomator:${Versions.uiAnimatorTest}"
        const val macroBenchMark = "androidx.benchmark:benchmark-macro-junit4:${Versions.macroBenchmark}"
    }
}