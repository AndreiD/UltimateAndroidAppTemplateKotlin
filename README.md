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

#### What it contains:

~~~~
apply plugin: 'com.android.application'
apply plugin: 'io.objectbox'

android {
  compileSdkVersion 26
  buildToolsVersion "26.0.1"

  defaultConfig {
    applicationId "com.andrei.template"
    minSdkVersion 23
    targetSdkVersion 26
    versionCode 1
    versionName "1.0"
    vectorDrawables.useSupportLibrary = true
    testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      minifyEnabled false
      shrinkResources false
      proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }
    debug {
      minifyEnabled false
      versionNameSuffix ".debug"
    }
  }

  compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_8
    targetCompatibility JavaVersion.VERSION_1_8
  }

  packagingOptions {
    exclude 'META-INF/DEPENDENCIES'
    exclude 'LICENSE.txt'
    exclude 'META-INF/LICENSE'
    exclude 'META-INF/LICENSE.txt'
    exclude 'META-INF/NOTICE'
    exclude 'LICENSE.txt'
  }

  lintOptions {
    warning 'InvalidPackage'
    abortOnError false
  }

  //needed if for espresso
  configurations.all {
    resolutionStrategy {
      force 'com.android.support:support-annotations:23.0.1'
    }
  }
}
~~~~

#### License MIT