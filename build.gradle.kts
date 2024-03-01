import io.gitlab.arturbosch.detekt.Detekt

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.serialization) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.detekt)
}

tasks.register<Detekt>("detektAll") {
    parallel = true
    setSource(projectDir)
    include("**/*.kt", "**/*.kts")
    exclude("**/resources/**", "**/build/**")
    config.setFrom(project.file("config/detekt/detekt.yml"))
}

dependencies {
    detekt(libs.detekt.cli)
    detektPlugins(libs.detekt.rules.compose)
}

val appName by extra("NewsBoard")
val appVersion by extra("1.0.0")
val appVersionCode by extra(1)
val compileSdk by extra(34)
val minSdk by extra(26)
val targetSdk by extra(34)