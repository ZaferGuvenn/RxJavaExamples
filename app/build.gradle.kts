import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

android {

    namespace = "com.lafimsize.rxjavaexamples"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lafimsize.rxjavaexamples"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"



        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties=Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String","API_KEY","\"${properties.getProperty("API_KEY")}\"")
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
    kotlinOptions {
        jvmTarget = "1.8"
    }

    kapt {
        correctErrorTypes = true
        useBuildCache = true
    }

    buildFeatures{
        dataBinding=true

        android.buildFeatures.buildConfig=true
    }

}


dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //rxjava
    implementation ("io.reactivex.rxjava3:rxjava:3.1.8")
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")



    //kapt icin room compiler bunun yerine ksp kullanabilirsin ancak databinding için kapt şart.
    kapt("androidx.room:room-compiler:2.6.1")

}