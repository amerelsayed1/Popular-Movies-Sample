//noinspection JcenterRepositoryObsolete
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        jcenter()
    }
}

@Suppress("UnstableApiUsage")
//noinspection JcenterRepositoryObsolete
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        jcenter()

    }
}

rootProject.name = "PopularMovies-Sample"
include(":movies-app")
include(":movies-app-compose")
