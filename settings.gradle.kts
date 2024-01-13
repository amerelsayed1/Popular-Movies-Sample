//noinspection JcenterRepositoryObsolete
pluginManagement {
    repositories {

        jcenter()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

@Suppress("UnstableApiUsage")
//noinspection JcenterRepositoryObsolete
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        google()
        jcenter()

    }
}

rootProject.name = "PopularMovies-Sample"
include(":app-compose")
include(":app")
