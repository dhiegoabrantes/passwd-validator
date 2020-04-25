FROM openjdk:11-jre-slim
RUN mkdir /app

COPY build/libs/*.jar /app/passwd-validation.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/passwd-validation.jar"]