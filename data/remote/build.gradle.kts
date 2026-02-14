import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.koin.compiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ktorfit)
}

kotlin {
    androidLibrary {
        namespace = "co.id.ilhamelmujib.githubuser.data.remote"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
        androidResources {
            enable = true
        }
        withHostTest {
            isIncludeAndroidResources = true
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    jvm("desktop")

//    js {
//        browser()
//    }

//    @OptIn(ExperimentalWasmDsl::class)
//    wasmJs {
//        browser()
//    }

    sourceSets {
        all {
            languageSettings {
                optIn("kotlin.time.ExperimentalTime")
            }
        }

        commonMain.dependencies {
            implementation(project(":core"))
            implementation(libs.koin.core)
            implementation(libs.koin.annotations)
            implementation(libs.kotlinx.serialization)
            implementation(libs.bundles.ktor.common)
            implementation(libs.ktorfit)
            implementation(libs.sandwich)
            implementation(libs.sandwich.ktorfit)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.android)
            if (project.gradle.startParameter.taskNames.any { it.contains("Debug") }) {
                implementation(libs.chucker)
            }else{
                implementation(libs.chucker.no.op)
            }
            implementation(libs.okhttp)
            implementation(libs.logging.interceptor)
        }

        appleMain.dependencies {
            implementation(libs.ktor.client.apple)
        }

        getByName("desktopMain").dependencies {
            implementation(libs.ktor.client.desktop)
        }

//        webMain.dependencies {
//            implementation(libs.ktor.client.web)
//        }

    }
}

ktorfit {
    compilerPluginVersion.set("2.3.3")
}
