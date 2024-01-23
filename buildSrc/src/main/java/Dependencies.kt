object Versions {
    const val standardLibrary = "1.9.22"
    const val coroutines = "1.3.9"
    const val hilt = "2.46"
    const val appCompat = "1.6.1"
    const val constraintLayout = "2.0.2"
    const val material = "1.6.0-alpha03"
    const val lifecycle = "2.5.1"
    const val annotations = "1.1.0"
    const val ktx = "1.3.2"
    const val glide = "4.15.1"
    const val retrofit = "2.9.0"
    const val okHttpLoggingInterceptor = "4.9.0"
    const val navigation = "2.5.3"

    //Testing
    const val junit4 = "4.13.1"
}

object DependenciesLibs {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.standardLibrary}"
    const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val retrofit = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingInterceptor}"
    const val scalableSdp = "com.intuit.sdp:sdp-android:1.0.6"
    const val scalableSsp = "com.intuit.ssp:ssp-android:1.0.6"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
}
