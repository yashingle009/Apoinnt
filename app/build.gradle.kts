plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.vaish.apoinnt"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.vaish.apoinnt"
        minSdk = 23
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-auth:22.3.1")
    implementation("androidx.navigation:navigation-runtime:2.7.7")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("com.google.firebase:firebase-database:21.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    dependencies {
        // Import the BoM for the Firebase platform
        implementation(platform("com.google.firebase:firebase-bom:33.0.0"))

        // Add the dependency for the Realtime Database library
        // When using the BoM, you don't specify versions in Firebase library dependencies
        implementation("com.google.firebase:firebase-database")
    }

    implementation ("com.google.android.material:material:1.3.0")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("com.google.android.gms:play-services-location:20.0.0")
    implementation("androidx.viewpager2:viewpager2:1.0.0")
 





}