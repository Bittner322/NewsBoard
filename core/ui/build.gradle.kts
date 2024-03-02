plugins {
    id("newsboard.android-compose")
    id("newsboard.anvil")
}

android.namespace = "com.mikhail.newsboard.core.ui"

dependencies {
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.graphics)
    implementation(libs.compose.tooling)
    implementation(libs.compose.material)
}