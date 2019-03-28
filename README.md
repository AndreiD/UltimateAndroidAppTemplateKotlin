Ultimate Android App Template Kotlin [level: Beginner]
==========================

## This is a simple start-template to save you a little time. It doesn't use dagger // mvp // mvvp or any other stuff that requires an more in depth knowledge of android.

#### How to use it:

Step 1:

* Fork/Clone this repo.
* or Manual mode: Download the zip file for this project.
* Check the compileSdkVersion, and buildToolsVersion to be the latest
* Run it and see that it's working on your emulator.
* IMPORTANT: Remove the libs that you don't need. Add those that you do.
* Star this repository

Step 2: ???
Step 3: Profit

#### Show some :heart: and star the repo to support the project


#### What it contains:

~~~~
apply plugin: 'com.android.application'

apply plugin: 'kotlin-android'

apply plugin: 'kotlin-android-extensions'

android {
    compileSdkVersion 28
    defaultConfig {
        applicationId "com.cryptoprices"
        minSdkVersion 21
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.appcompat:appcompat:1.0.0-beta01'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'

    androidTestImplementation 'androidx.test:runner:1.1.0-alpha4'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.0-alpha4'
    implementation 'androidx.recyclerview:recyclerview:1.0.0-beta01'
    implementation 'androidx.cardview:cardview:1.0.0-beta01'

    implementation "com.squareup.retrofit2:retrofit:2.4.0"
    implementation "com.squareup.retrofit2:adapter-rxjava2:2.3.0"
    implementation "com.squareup.retrofit2:converter-gson:2.3.0"

    implementation "io.reactivex.rxjava2:rxandroid:2.1.1"

    testImplementation 'junit:junit:4.12'

}

~~~~

#### License MIT