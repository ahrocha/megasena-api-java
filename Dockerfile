# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built application JAR into the container
COPY target/*.jar app.jar
COPY .env .env

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
