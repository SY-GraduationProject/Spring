# FROM arm64v8/openjdk:8
FROM openjdk:8-jdk-alpine

# Make port 8080 available to the world outside this container
EXPOSE 5000

# The application's jar file
ARG JAR_FILE=build/libs/refrigerator_management_app-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
COPY ${JAR_FILE} rm.jar

# Run the jar file
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/rm.jar"]
