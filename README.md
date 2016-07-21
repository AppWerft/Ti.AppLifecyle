#Ti.AppLifecycle

This is a Titanium module for detecting some app events. Thanks to [Roamler](https://www.roamler.com/)  ![](https://www.roamler.com/images/logo-roamler-shield.png) in Amsterdam for sponsoring and René for patience and support. <img src="https://secure.gravatar.com/avatar/325662ace9877e9af4291aff59ec9318.jpg?s=512&d=https%3A%2F%2Fa.slack-edge.com%2F7fa9%2Fimg%2Favatars%2Fava_0026-512.png" width=80/>

A [description](https://github.com/AppWerft/TitaniumAndroidModuleDevelopment/blob/master/09-Ti.AppEvents.md) is available too.

##paused
The user has left the app. I.e. by calling launch screen or starting a new activity from app.

##resumed
The user comes back

##screenoff
"The screen is black" (Button Power off)

##screenon
Screen reopened


You can specify the test interval (in ms) in tiapp.xml:

```xml
<property name="LIFECYCLE_TESTINTERVAL" type="int">200</property>
```


This test interval is only for `paused` and `resumed`. Screen events are event triggered.

##Usage

You have only to include in tiapp.xml:
```xml
<module platform="android">de.appwerft.applifecycle</module>
```

No `require` !

Just call in your app.js:

```javascript
["screenon screenoff paused resumed"].split(' ').forEach(function(eventName){
    Ti.App.addEventListener(eventName, function() {
        console.log(arguments[0]);
    });
});
```
