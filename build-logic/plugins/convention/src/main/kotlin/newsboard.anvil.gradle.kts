import gradle.kotlin.dsl.accessors._ed731d98ec7910fd067439b6a4440036.anvil
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("com.squareup.anvil")
}

anvil {
    generateDaggerFactories.set(true)
}

dependencies {
    "implementation"(libs.dagger.core)
}