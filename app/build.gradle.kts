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

android {
    namespace = BuildConfig.id
    compileSdk = BuildConfig.compileSdk

    defaultConfig {
        applicationId = BuildConfig.id
        minSdk = BuildConfig.minSdk
        targetSdk = BuildConfig.compileSdk
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName
        testInstrumentationRunner = BuildConfig.testInstrumentationRunner
    }

    buildFeatures {
        buildConfig = true
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
        sourceCompatibility = BuildConfig.javaVersion
        targetCompatibility = BuildConfig.javaVersion
    }

    kotlinOptions {
        jvmTarget = BuildConfig.javaVersion.toString()
    }

}


dependencies {
    // Application dependencies
    implementation(DependenciesLibs.kotlinStdLib)
    implementation(DependenciesLibs.appCompat)
    implementation(DependenciesLibs.ktxCore)
    implementation(DependenciesLibs.constraintLayout)

    implementation(DependenciesLibs.material)

    implementation(DependenciesLibs.kotlinCoroutines)
    implementation(DependenciesLibs.kotlinCoroutinesAndroid)

    implementation(DependenciesLibs.retrofit)
    implementation(DependenciesLibs.okHttpLoggingInterceptor)


    implementation(DependenciesLibs.glide)

    /** UI Dependencies*/
    implementation(DependenciesLibs.scalableSdp)
    implementation(DependenciesLibs.scalableSsp)
    implementation(DependenciesLibs.navigationUi)
    implementation(DependenciesLibs.navFragment)

    implementation(DependenciesLibs.viewModel)
    implementation(DependenciesLibs.liveData)


    //Dependency Injection
    implementation(DependenciesLibs.hilt)
    kapt(DependenciesLibs.hiltCompiler)

    testImplementation("io.mockk:mockk:1.13.5")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.2")
    androidTestImplementation("androidx.test:core:1.5.0")
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
}

kapt {
    correctErrorTypes = true
}