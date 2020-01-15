# Qvik Challange

Introduction
------------

The application uses Clean Architecture based on MVVM and Repository patterns.
Implemented google recommended architecture pattern[Guide to app architecture](https://developer.android.com/jetpack/docs/guide).

The application is written entirely in Kotlin.

Android Jetpack is used as an Architecture glue including but not limited to ViewModel, LiveData,
Lifecycles, Navigation, Room and Data Binding.

The application gets the data from local article_list.json and channel_list.json file, Loads the data and save into
room database, which serves as a single source of truth and support offline mode.

Kotlin Coroutines manage background threads with simplified code and reducing needs for callbacks.
Combination of Coroutines and Kotlin build in functions are used.

RxJava is used for reactive programming principle, which provides schedulars for specific thread management,
also provides wide range of functions for data transformation.

Dagger 2 is used for dependency injection.


Application overview
------------
A sample app consist of 4 screens : First screen fetches the channels, then next will show articles related
to a channel and then next screen shows the details of the article.

Getting Started
---------------
This project uses the Gradle build system. To build this project, use the
`gradlew build` command or use "Import Project" in Android Studio.

To run Gradle tasks for testing the project:
* `test` - for running unit tests

Libraries / Architecture Used
--------------

The application goal is to show case current Android Architecture state using out of box
Android tools made by Google (Android Jetpack) and 3rd party community driven libraries.

Android Jetpack is a set of components, tools and guidance to make great Android apps. They bring
together the existing Support Library and Architecture Components.


Architecture Used : MVVM architecutre with repository pattern.
![alt text](https://github.com/ank27/QvikApplication/blob/master/images/android_architecture.png)


Future Improvements
---------------
- Add more test cases to cover maximum codebase.
- Create BaseViewHolder to manage different types of data, rather than creating different class for each type of data
this BaseViewHolder delegates the data.

Android Studio IDE setup
------------------------
For development, the latest version of Android Studio is required. The latest version can be
downloaded from [here](https://developer.android.com/studio/).
