plugins {
    id("newsboard.android-compose")
    id("newsboard.anvil")
    kotlin("plugin.serialization")
}

android.namespace = "com.mikhail.newsboard.features.registration.impl"

dependencies {
    implementation(projects.features.registration.api)
    implementation(projects.core.ui)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.graphics)
    implementation(libs.compose.tooling)
    implementation(libs.compose.material)
    implementation(libs.decompose)
    implementation(libs.decompose.jetpack)
}