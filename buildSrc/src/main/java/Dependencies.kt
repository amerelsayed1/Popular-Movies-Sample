object Versions {
    const val standardLibrary = "1.8.10"
    const val coroutines = "1.3.9"
    const val hilt = "2.45"
    const val appCompat = "1.2.0"
    const val constraintLayout = "2.0.2"
    const val recyclerView = "1.1.0"
    const val cardView = "1.0.0"
    const val material = "1.6.0-alpha03"
    const val lifecycle = "2.5.1"
    const val lifecycleExtensions = "2.5.1"
    const val annotations = "1.1.0"
    const val ktx = "1.3.2"
    const val glide = "4.15.1"
    const val retrofit = "2.9.0"
    const val okHttpLoggingInterceptor = "4.9.0"
    const val navigation = "2.5.3"
    const val epoxy_v = "4.0.0-beta6"
    const val epoxy_databinding_v = "3.11.0"
    const val cardSlider = "1.0.1"
    const val tabLayoutMediator = "1.0.1"
    const val circleimageview = "3.1.0"
    const val skeletonlayoutVersion = "4.0.0"

    //Dev
    const val leakCanary = "2.9.1"

    //Testing
    const val junit4 = "4.13.1"
    const val mockk = "1.10.0"
    const val robolectric = "4.4"
    const val kluent = "1.14"
    const val testRunner = "1.1.0"
    const val espressoCore = "3.2.0"
    const val espressoIntents = "3.1.0"
    const val testExtensions = "1.1.1"
    const val testRules = "1.1.0"
    const val hiltTesting = "2.45"
}

object DependenciesLibs {
    const val skeletonlayoutVersion =
        "com.faltenreich:skeletonlayout:${Versions.skeletonlayoutVersion}"
    const val skeletonKoleton = "com.ericktijerou.koleton:koleton:1.0.0-beta01"
    const val shimmer = "com.facebook.shimmer:shimmer:0.5.0"
    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleimageview}"
    const val tabLayoutMediator = "io.github.ahmad-hamwi:tabsync:1.0.1"
    const val cardSlider = "com.github.IslamKhSh:CardSlider:${Versions.cardSlider}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.standardLibrary}"
    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val kotlinCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val koleton = "com.ericktijerou.koleton:koleton:1.0.0-beta01"
    const val OtpView = "com.github.aabhasr1:OtpView:v1.1.2-ktx"
    const val html_textview = "com.github.sakacyber:html-textview:1.0.13"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
    const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val pdfViewer = "com.github.barteksc:android-pdf-viewer:2.8.2"
    const val androidAnnotations = "androidx.annotation:annotation:${Versions.annotations}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val retrofit = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingInterceptor}"
    const val scalableSdp = "com.intuit.sdp:sdp-android:1.0.6"
    const val scalableSsp = "com.intuit.ssp:ssp-android:1.0.6"
    const val anko = "org.jetbrains.anko:anko:0.10.8"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val spinKit = "com.github.ybq:Android-SpinKit:1.4.0"
    const val aVLoadingIndicatorView = "com.wang.avi:library:2.1.3"
    const val places = "com.google.android.libraries.places:places:3.1.0"
    const val playServicesMaps = "com.google.android.gms:play-services-maps:18.0.2"
    const val playServicesLocation = "com.google.android.gms:play-services-location:19.0.1"
    const val stickyScrollView = "com.github.amarjain07:StickyScrollView:1.0.3"
    const val easypermissions = "com.guolindev.permissionx:permissionx:1.6.4"
    const val uce_handler = "com.github.RohitSurwase.UCE-Handler:uce_handler:1.4"
    const val viewpagerindicator = "com.github.zhpanvip:viewpagerindicator:1.2.1"

    //debug
    const val requestDebugRequestly = "io.requestly:requestly-android:2.4.10"
    const val requestDebugRequestlyAndroidNoop = "io.requestly:requestly-android-noop:2.4.10"
    const val requestDebugRequestlyAndroidOkhttp = "io.requestly:requestly-android-okhttp:2.4.10"
    const val requestDebugRequestlyAndroidOkhttpNoop =
        "io.requestly:requestly-android-okhttp-noop:2.4.10"

    const val chucker = "com.github.chuckerteam.chucker:library:4.0.0"
    const val chucker_no_op = "com.github.chuckerteam.chucker:library-no-op:4.0.0"
}

object DevDependenciesLibs {
    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
}

object TestingDependenciesLibs {
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val kluent = "org.amshove.kluent:kluent:${Versions.kluent}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val testRules = "androidx.test:rules:${Versions.testRules}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espressoIntents}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtensions}"
    const val hiltTesting = "com.google.dagger:hilt-android-testing:${Versions.hiltTesting}"
}