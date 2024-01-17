//noinspection JcenterRepositoryObsolete
pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
        jcenter()
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
