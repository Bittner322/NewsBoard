@file:Suppress("Filename")

import com.android.build.gradle.BaseExtension
import com.mikhail.newsboard.buildlogic.AppConfig
import org.gradle.api.JavaVersion
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun BaseExtension.defaultAndroid(target: Project) {
    configureDefaultConfig(target)
    configureBuildTypes()
    configureBuildFeatures()
    configureCompileOptions()

    target.suppressOptIn()
}

@Suppress("UnstableApiUsage")
private fun BaseExtension.configureDefaultConfig(project: Project) {
    compileSdkVersion(AppConfig.compileSdk)
    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.appVersionCode
        versionName = AppConfig.appName

        consumerProguardFiles(
            "consumer-rules.pro"
        )

        packagingOptions {
            resources.excludes += "META-INF/LICENSE-LGPL-2.1.txt"
            resources.excludes += "META-INF/LICENSE-LGPL-3.txt"
            resources.excludes += "META-INF/LICENSE-W3C-TEST"
            resources.excludes += "META-INF/DEPENDENCIES"
            resources.excludes += "*.proto"
        }

        testOptions {
            unitTests {
                isIncludeAndroidResources = true
            }
        }
    }
}

private fun BaseExtension.configureBuildTypes() {
    buildTypes {
        maybeCreate("debug").apply {
            buildConfigField("boolean", "INTERNAL", "true")
            multiDexEnabled = true
            isDebuggable = true
        }
        maybeCreate("internal").apply {
            setMatchingFallbacks("debug")
            sourceSets.getByName(this.name).setRoot("src/debug")

            buildConfigField("boolean", "INTERNAL", "true")
        }
        maybeCreate("release").apply {
            buildConfigField("boolean", "INTERNAL", "true")
        }
    }
}

@Suppress("UnstableApiUsage", "ForbiddenComment")
private fun BaseExtension.configureBuildFeatures() {
    // TODO: Disable by default
    //  BuildConfig is java source code. Java and Kotlin at one time affect build speed.
    buildFeatures.buildConfig = true
    // Disable by default. ViewBinding needed only for few modules.
    // No need to enable this feature for all modules.
    buildFeatures.viewBinding = false
    buildFeatures.aidl = false
    buildFeatures.compose = false
    buildFeatures.prefab = false
    buildFeatures.renderScript = false
    buildFeatures.resValues = false
    buildFeatures.shaders = false
}

private fun BaseExtension.configureCompileOptions() {
    compileOptions.sourceCompatibility = JavaVersion.VERSION_17
    compileOptions.targetCompatibility = JavaVersion.VERSION_17
}

@Suppress("MaxLineLength")
private fun Project.suppressOptIn() {
    tasks.withType<KotlinCompile>()
        .configureEach {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
}

fun <BuildTypeT> NamedDomainObjectContainer<BuildTypeT>.internal(
    action: BuildTypeT.() -> Unit
) {
    maybeCreate("internal").action()
}

fun <BuildTypeT> NamedDomainObjectContainer<BuildTypeT>.release(
    action: BuildTypeT.() -> Unit
) {
    maybeCreate("release").action()
}
