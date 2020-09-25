plugins {
    id(BuildPlugins.androidLibrary)
    kotlin(BuildPlugins.kotlinAndroid)
    kotlin(BuildPlugins.kotlinExtensions)
    kotlin(BuildPlugins.kapt)
}

android {
    compileSdkVersion(Config.AndroidSdk.compile)
    buildToolsVersion(BuildPlugins.Versions.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Config.AndroidSdk.min)
        targetSdkVersion(Config.AndroidSdk.target)
        versionCode = Config.Version.code
        versionName = Config.Version.name

        testInstrumentationRunner = Config.androidJUnitRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.arr"))))
}

//kotlin
dependencies {
    implementation(Libraries.kotlinStdLib)

    //coroutines
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesAndroid)
}

//androidX
dependencies {
    implementation(Libraries.ktxCore)
}

//google
dependencies {
//    implementation 'com.google.android.material:material:1.3.0-alpha02'
}

//module
dependencies {
    implementation(files("libs/commons-net-3.7.jar"))
}

//test
dependencies {
    testImplementation (TestLibraries.junit4)
    androidTestImplementation (TestLibraries.testRunner)
    androidTestImplementation (TestLibraries.espresso)
}