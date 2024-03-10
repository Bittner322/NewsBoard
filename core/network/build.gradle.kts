plugins {
    id("newsboard.android-lib")
}

android.namespace = "com.mikhail.newsboard.core.network"

dependencies {
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.auth)
    implementation(libs.play.services.auth)
}