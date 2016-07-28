#!/bin/bash

APPID=de.appwerft.applifecycle
VERSION=1.0.3

rm -rf build/;cd android; ant clean;ant ;  unzip -uo  dist/$APPID-android-$VERSION.zip  -d  ~/Library/Application\ Support/Titanium/;cd ..;

