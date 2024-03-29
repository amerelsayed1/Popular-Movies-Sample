plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
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
        targetSdk = BuildConfig.targetSdk
        versionCode = BuildConfig.versionCode
        versionName = BuildConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

    flavorDimensions.addAll(arrayListOf(FlavorDimensions.DEFAULT))
    productFlavors {
        create(ProductFlavors.PUBLIC) {
            dimension = FlavorDimensions.DEFAULT
            buildConfigField("String", "BaseUrl", "\"https://api.themoviedb.org/\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("com.github.bumptech.glide:compose:1.0.0-alpha.1")

}

kapt {
    correctErrorTypes = true
}