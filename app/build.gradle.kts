plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.detekt)
    kotlin("kapt")
}

android {
    namespace = "com.mikhail.newsboard"
    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {
        applicationId = "com.mikhail.newsboard"
        minSdk = rootProject.extra["minSdk"] as Int
        targetSdk = rootProject.extra["compileSdk"] as Int
        versionCode = rootProject.extra["appVersionCode"] as Int
        versionName = rootProject.extra["appVersion"] as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.10"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(projects.core.ui)
    implementation(projects.core.database)
    implementation(projects.core.decompose)
    implementation(projects.features.onboarding.api)
    implementation(projects.features.onboarding.impl)
    implementation(projects.features.registration.api)
    implementation(projects.features.registration.impl)

    implementation(libs.decompose)
    implementation(libs.decompose.jetpack)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.ktx)
    implementation(libs.lifecycle)
    implementation(libs.viewmodel)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.graphics)
    implementation(libs.compose.tooling)
    implementation(libs.compose.material)
    implementation(libs.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.core)
    implementation(libs.kotlinx.serialization.converter)
    implementation(libs.retrofit)
    implementation(libs.coroutines)
    implementation(libs.dagger.core)
    implementation(libs.dagger.android.support)
    kapt(libs.dagger.android.processor)
    kapt(libs.dagger.compiler)
    implementation(libs.room.ktx)
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)
    ksp(libs.room.compiler)
    implementation(libs.ksp)
    debugImplementation(libs.compose.tooling.preview)
    debugImplementation(libs.compose.test.manifest)
}