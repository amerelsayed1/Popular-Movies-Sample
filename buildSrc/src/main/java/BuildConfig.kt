import org.gradle.api.JavaVersion

class BuildConfig {
    companion object {
        val id = "com.iamer.movies"
        val versionCode = 1
        val versionName = "1.0"

        val compileSdk = 34
        val minSdk = 24
        val targetSdk = 34

        val javaVersion = JavaVersion.VERSION_17
        val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}