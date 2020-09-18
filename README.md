# Future Email

This is an Android app that sends editable emails after countdown.
It is mplemented based on javamail library and SMTP server.

My email and SMTP password were deleted from this project due to the obvious reason. 
You may fill your own email address and SMTP password at app\src\main\java\com\example\myapplication\MainActivity.java (line 69)


## Installation

Since the email address and SMTP password was deleted, providing an **.apk** will be meaningless. You may import the project to Android Studio (or othre IDEs), fill your email address and SMTP password in, and generate your own **.apk** file. 

The download URL and instructions for Installation can be found in the official site of Android Studio: https://developer.android.com/studio/
The Javamail library can be found in **app/libs**, but if you would like to install the latest version of javamail, here is the URL: https://javaee.github.io/javamail/Android


## How To Use the App

1. Enter the receiver's email address in **Email** section. 
2. Enter the subject in **Subject** section. 
3. Enter the text in **Content** section. 
4. Set the countdown in the **Send after __ hour(s)** section. Float numbers will be accepted (EG: 0.05 -> Send after 0.05 hours -> Send After 3 mins)
5. Click **SAVE CHANGES** button. A toast will prompt. 
6. If you want to send the email immediately, click the **SEND NOW!** button. A toast will prompt after you clicked the **SEND NOW!** button. Otherwise, click **READY** to enter the countdown interface.
7. Initially, the countdown is frozen. Click the "START/RESET" button to start the countdown. 
8. The reset option is mean to be clicked after the countdown terminates. If you click "START/RESET", the clock will be reset, but multiple emails will be sent. If you would like to cancel the email sending process at any moment, use the **CANCEL** button. It will cancel the countdown and bring you back to the main interface. 


## Classes Introduction:

4 Classes could be found in **app/src/main/java/com/example/myapplication/**. 

**MainActivity.java** describes the main interface. It contains on-click methods for button **SAVE CHANGES**, **SEND NOW!** and **READY**.

**DisplayMessageActivity.java** describes the countdown interface. It contains on-click methods for button **START/RESET** and **CANCEL**. A very basic countdown clock is implemented in this class.

**Eml.java** encapsulates the javamail library. The Send() method takes 2 String parameters (subject and content) and send the email with input subject & content. 

**Save.java** saves the user's input (email, subject and content) and provides information when sending the emails.




