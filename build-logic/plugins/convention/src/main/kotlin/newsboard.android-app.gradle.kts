
import com.android.build.gradle.BaseExtension
import com.mikhail.newsboard.buildlogic.AppConfig

plugins {
    id("com.android.application")
    id("kotlin-android")
}

@Suppress("UnstableApiUsage")
configure<BaseExtension> {
    defaultAndroid(project)

    defaultConfig {
        applicationId = AppConfig.applicationId
    }

    buildTypes {
        internal {
            isShrinkResources = true
            isMinifyEnabled = true
            consumerProguardFile(
                "proguard-rules.pro"
            )
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isShrinkResources = true
            isMinifyEnabled = true
            consumerProguardFile(
                "proguard-rules.pro"
            )
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}