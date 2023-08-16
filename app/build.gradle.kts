plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

private object BuildTypes {
    const val DEBUG = "debug"
    const val RELEASE = "release"
}

private object ProductFlavors {
    const val PUBLIC = "public"
}

private object FlavorDimensions {
    const val DEFAULT = "default"
}

class AppConfig {
    val id = "com.iamer.movies"
    val versionCode = 1
    val versionName = "1.0"

    val compileSdk = 34
    val minSdk = 24
    val targetSdk = 34

    val javaVersion = JavaVersion.VERSION_17
    val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

val appConfig = AppConfig()

android {
    namespace = appConfig.id
    compileSdk = appConfig.compileSdk

    defaultConfig {
        applicationId = appConfig.id
        minSdk = appConfig.minSdk
        targetSdk = appConfig.compileSdk
        versionCode = appConfig.versionCode
        versionName = appConfig.versionName
        testInstrumentationRunner = appConfig.testInstrumentationRunner
    }

    buildFeatures {
        buildConfig = true
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName(BuildTypes.DEBUG) {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = true
            //proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName(BuildTypes.RELEASE) {
            isMinifyEnabled = false
            isShrinkResources = false
            isDebuggable = false
            // signingConfig = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    flavorDimensions.addAll(arrayListOf(FlavorDimensions.DEFAULT))
    productFlavors {
        create(ProductFlavors.PUBLIC) {
            dimension = FlavorDimensions.DEFAULT
            buildConfigField("String", "BaseUrl", "\"https://api.themoviedb.org/\"")
        }
    }

    compileOptions {
        sourceCompatibility = appConfig.javaVersion
        targetCompatibility = appConfig.javaVersion
    }

    kotlinOptions {
        jvmTarget = appConfig.javaVersion.toString()
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}


dependencies {
    // Application dependencies
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)

    implementation(Libraries.material)

    implementation(Libraries.kotlinCoroutines)
    implementation(Libraries.kotlinCoroutinesAndroid)

    implementation(Libraries.retrofit)
    implementation(Libraries.okHttpLoggingInterceptor)


    implementation(Libraries.glide)

    /** UI Dependencies*/
    implementation(Libraries.scalableSdp)
    implementation(Libraries.scalableSsp)
    implementation(Libraries.navigationUi)
    implementation(Libraries.navFragment)

    implementation(Libraries.viewModel)
    implementation(Libraries.liveData)


    //Dependency Injection
    implementation(Libraries.hilt)
    kapt(Libraries.hiltCompiler)

    testImplementation("io.mockk:mockk:1.13.5")

    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.2")
    androidTestImplementation("androidx.test:core:1.5.0")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")


    /*Compose Dependencies*/
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.0")
    implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1")

    /*
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.20")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.3.1")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0-alpha01")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0-alpha01")
    implementation("com.github.bumptech.glide:glide:4.15.1")

    implementation("androidx.activity:activity-ktx:1.7.2")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")*/

}

kapt {
    correctErrorTypes = true
}


object Kotlin {
    const val standardLibrary = "1.8.10"
    const val coroutines = "1.3.9"
}

object Libraries {
    private object Versions {
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
    }

    const val skeletonlayoutVersion =
        "com.faltenreich:skeletonlayout:${Versions.skeletonlayoutVersion}"
    const val skeletonKoleton = "com.ericktijerou.koleton:koleton:1.0.0-beta01"
    const val shimmer = "com.facebook.shimmer:shimmer:0.5.0"

    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleimageview}"
    const val tabLayoutMediator = "io.github.ahmad-hamwi:tabsync:1.0.1"
    const val cardSlider = "com.github.IslamKhSh:CardSlider:${Versions.cardSlider}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Kotlin.standardLibrary}"
    const val kotlinCoroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Kotlin.coroutines}"
    const val kotlinCoroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Kotlin.coroutines}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    const val koleton = "com.ericktijerou.koleton:koleton:1.0.0-beta01"

    //const val pinView = "com.github.GoodieBag:Pinview:v1.4"
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

object TestLibraries {
    private object Versions {
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

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val kluent = "org.amshove.kluent:kluent:${Versions.kluent}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val testRules = "androidx.test:rules:${Versions.testRules}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoIntents =
        "androidx.test.espresso:espresso-intents:${Versions.espressoIntents}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtensions}"
    const val hiltTesting = "com.google.dagger:hilt-android-testing:${Versions.hiltTesting}"

}

object DevLibraries {
    private object Versions {
        const val leakCanary = "2.9.1"
    }

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
}
