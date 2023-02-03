# Fetch-Android-Test
The app is used to display a list of data from hiring.json. The app ensures that all data is grouped by "listId" and sorted first in "listId" then by "name" when displaying. Additionally, the app implements a filtering mechanism that automatically removes any items with blank or null "name" fields, ensuring that only relevant and accurate data is displayed.

# User Interface
The list can be scrolled up and down.
![user interface](./img/ui.png)

# Technical Specifications
 - Android SDK: 30 (release: 11)
 - Android Studio 2022.1.1
 - Android Gradle Plugin Version 7.4.1
 - Gradle Version 7.5
 - Emulator used when developing: Pixel 2 API 30, Pixel 6 Pro API 33
 
# Installation Process
    1. Android device:
        - Enable Unknown sources for the device.
        - Locate the APK file on your device and tap on it to start the installation process.
        - Once the installation is completed, you should be able to launch the app.
    2. Android Studio:
        - Clone this repo.
        - Open FetchTest in Android Studio.
        - Sync Gradle and run emulator.

# User Guide
Users can scroll up and down to see the list sorted by "listId" in ascending order and "name" in lexicographical order.
