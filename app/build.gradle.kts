plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    kotlin(BuildPlugins.kapt)
}

android {
    compileSdkVersion(Config.AndroidSdk.compile)

    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion(Config.AndroidSdk.min)
        targetSdkVersion(Config.AndroidSdk.target)
        versionCode = Config.Version.code
        versionName = Config.Version.name

        testInstrumentationRunner = Config.androidJUnitRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.arr"))))
}

//kotlin
dependencies {
    implementation(Libraries.kotlinStdLib)
}

//androidX
dependencies {
    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)
}

//google
dependencies {
    implementation(Libraries.material)
}

//module
dependencies {
    implementation(project(":domaininfo"))
}

//test
dependencies {
    testImplementation (TestLibraries.junit4)
    androidTestImplementation (TestLibraries.testRunner)
    androidTestImplementation (TestLibraries.espresso)
}