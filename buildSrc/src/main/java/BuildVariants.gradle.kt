import com.android.build.gradle.AppExtension
import org.gradle.api.Project

private object ProductFlavors {
    const val PUBLIC = "public"
}

fun Project.configureVariants() {
    extensions.getByType(AppExtension::class.java).run {
        flavorDimensions("version")
        productFlavors {
            create(ProductFlavors.PUBLIC) {
                dimension = "version"
                applicationIdSuffix = ".demo"
                buildConfigField("String", "BaseUrl", "\"https://api.themoviedb.org/\"")
            }
        }
    }
}
