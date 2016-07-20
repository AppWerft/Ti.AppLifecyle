#Ti.AppLifecycle

This is a Titanium module for detecting some app events:

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
["screenon screenoff paused resumed"].split(' ').forEach(function(event){
    Ti.App.addEventListener(event, function(e) {
    console.log(event);
});
```
