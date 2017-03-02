#Ti.AppLifecycle

This is a Titanium module for detecting a couple app events.

Thanks to [Roamler](https://www.roamler.com/)  in Amsterdam for sponsoring and René for patience and support. 

<img src="https://secure.gravatar.com/avatar/325662ace9877e9af4291aff59ec9318.jpg?s=512&d=https%3A%2F%2Fa.slack-edge.com%2F7fa9%2Fimg%2Favatars%2Fava_0026-512.png" width=40/> <img src="https://www.roamler.com/images/logo-roamler-shield.png" height=40/>

A [description](https://github.com/AppWerft/TitaniumAndroidModuleDevelopment/blob/master/09-Ti.AppLifeCycle.md) is available too.

#Events

##paused
The user has left the app. I.e. by calling launch screen or starting a new activity from the app.

##resumed
The user comes back to the app

##screenoff
"The screen is black" (Button Power off, or sleep)

##screenon
Screen reopened and app is in foreground again


#TestInterval
In order to properly read the `paused` and `resumed` events we need a TestInterval as Android does not provide an event for this. A good TestInterval would be 200-500ms. If the testInterval is too long it might not be able to trigger an event as the app is already paused at that stage.

You can specify the test interval (in ms) in `tiapp.xml`:

```xml
<property name="LIFECYCLE_TESTINTERVAL" type="int">500</property>
```

##Usage

You have only to include in tiapp.xml:
```xml
<module platform="android">de.appwerft.applifecycle</module>
```

In the app it is not needed to `require` this module. Just including it in `tiapp.xml` is enough to get it to work

In the app you will receive the events through `Ti.App.addEventListener()` as shown below.

```javascript
["screenon screenoff paused resumed"].split(' ').forEach(function(eventName){
    Ti.App.addEventListener(eventName, function() {
        console.log(arguments[0]);
    });
});

// static pull:
require("de.appwerft.applifecycle").isInForeground();  // true/false

```
