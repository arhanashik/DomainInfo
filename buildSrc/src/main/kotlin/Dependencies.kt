
const val kotlinVersion = "1.4.10"

object BuildPlugins {

    object Versions {
        const val gradlePluginVersion = "4.0.1"
        const val buildToolsVersion = "29.0.3"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePluginVersion}"
    const val kotlinGradlePlugin  = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication  = "com.android.application"
    const val androidLibrary      = "com.android.library"
    const val kotlinAndroid       = "android"
    const val kotlinExtensions    = "android.extensions"
    const val kapt                = "kapt"
}

object Config {
    const val applicationId = "com.workfort.domaininfoexample"
    object AndroidSdk {
        const val min     = 18
        const val compile = 29
        const val target  = compile
    }

    object Version {
        const val code = 11
        const val name = "1.1.9"
    }

    const val androidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Libraries {
    private object Versions {
        const val jetpack           = "1.2.0"
        const val constraintLayout  = "2.0.1"
        const val ktx               = "1.3.1"
        const val material          = "1.3.0-alpha02"

        const val coroutinesCore    = "1.3.7"
        const val coroutinesAndroid = "1.3.6"
    }

    const val kotlinStdLib     = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val coroutinesCore   = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesCore}"
    const val coroutinesAndroid= "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroid}"

    const val appCompat        = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore          = "androidx.core:core-ktx:${Versions.ktx}"
    const val material         = "com.google.android.material:material:${Versions.material}"
}

object TestLibraries {
    private object Versions {
        const val junit4     = "4.12"
        const val testRunner = "1.1.2"
        const val espresso   = "3.3.0"
    }
    const val junit4     = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso   = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}