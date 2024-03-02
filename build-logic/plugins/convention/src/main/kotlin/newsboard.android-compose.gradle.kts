import com.android.build.gradle.BaseExtension

plugins {
    id("newsboard.android-lib")
}

@Suppress("UnstableApiUsage")
configure<BaseExtension> {
    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
}
