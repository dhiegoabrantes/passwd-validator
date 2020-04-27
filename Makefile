default:
	cat ./Makefile
dist:
	./gradlew clean build
image:
	docker build -t dhiegoabrantes/passwd-validator:latest .
run:
	docker run -p 8080:8080 dhiegoabrantes/passwd-validator:latest
run-bash:
	docker run -i -t dhiegoabrantes/passwd-validator:latest /bin/bash
run-java: dist
	mv ./build/libs/passwd-validator-*.jar ./build/libs/app.jar
	java -jar ./build/libs/app.jar
up: dist image run