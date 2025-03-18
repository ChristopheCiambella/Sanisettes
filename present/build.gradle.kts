plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.detekt)
}

android {
    namespace = "eu.ciambella.sanisettes.present"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    sourceSets {
        getByName("test").resources.srcDirs("src/main/assets")
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    // Clean architecture
    implementation(project(":design-system"))
    implementation(project(":design-system-property"))
    implementation(project(":domain"))

    // Dependency injection
    implementation(libs.koin.core)
    implementation(libs.koin.compose)

    // Kotlin
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.coroutines.core)

    // Compose
    implementation(libs.androidx.navigation.compose)
    implementation(libs.accompanist.permissions)

    // Tests
    testImplementation(libs.tests.junit)
    testImplementation(libs.tests.mockk)
    testImplementation(libs.tests.core)
    testImplementation(libs.tests.core.testing)
}
