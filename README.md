# Mobile Vision Prototype

A simple Android application to figure out the effectiveness of [Text Recognition API](https://developers.google.com/vision/text-overview), a part of [Mobile Vision by Google.](https://developers.google.com/vision/)

##### To run (works with Android Lollipop and higher only):
1. Clone this repository from the terminal.
```
git clone https://github.com/arjunkrishnababu96/mobile-vision-prototype.git
```

2. Open the project downloaded above in Android Studio.
3. Run on an Android virtual device (ie., an emulator).

This app is self-contained. The images it uses are in the `res/drawable` directory. The current image shown can be selected via the [`spinner`](https://developer.android.com/guide/topics/ui/controls/spinner.html) at the top of the app.

Press the button to recognize the text from the image. The recognized text should pop up in a [Toast](https://developer.android.com/guide/topics/ui/notifiers/toasts.html) within a few seconds.

##### To test with additional images:
1. Convert your image to `.png` format. Reduce the file-size of the image if possible.
2. Change the filename of the image to start with `"se_pic"`. See the existing files in the `res/drawable` for an example.
3. Copy your image, right-click the `res/drawable` folder from Android Studio, and select `paste`.
4. Run the app. The newly added images should now be available in the `spinner` menu.

**NOTE:** Adding more than four images at a time may cause the app to crash (because this prototype app is not optimized for efficient use of memory).
