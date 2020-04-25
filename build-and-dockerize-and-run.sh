#!/bin/bash

./gradlew clean build
docker build -t dhiegoabrantes/passwd-validator:latest .
docker run -d -p 8080:8080 dhiegoabrantes/passwd-validator:latest
