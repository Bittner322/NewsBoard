enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NewsBoard"
include(
    ":app",
    ":core:ui",
    ":core:database",
    ":core:decompose",
    ":features:onboarding:api",
    ":features:onboarding:impl",
    ":features:registration:api",
    ":features:registration:impl",
)
 