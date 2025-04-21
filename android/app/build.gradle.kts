plugins {
    // Aplica los plugins al módulo app, utilizando el catálogo.
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.services)
}

import com.android.build.api.dsl.ApplicationExtension
        import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

        android {
            namespace = "com.example.app_delivery"
            compileSdk = 34

            defaultConfig {
                applicationId = "com.example.app_delivery"
                minSdk = 24
                targetSdk = 34
                versionCode = 1
                versionName = "1.0"

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
            configure<KotlinAndroidProjectExtension> {
                jvmToolchain(8)
            }
            buildFeatures {
                viewBinding = true
            }
        }

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}