#!/bin/bash

./gradlew clean build
mv ./build/libs/passwd-validator-*.jar ./build/libs/app.jar
java -jar ./build/libs/app.jar