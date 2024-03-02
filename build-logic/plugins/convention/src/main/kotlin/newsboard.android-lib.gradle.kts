import com.android.build.gradle.BaseExtension
import org.gradle.kotlin.dsl.configure

plugins {
    id("com.android.library")
    id("kotlin-android")
}

configure<BaseExtension> {
    defaultAndroid(project)
}