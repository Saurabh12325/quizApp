# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container and rename it to app.jar
COPY target/quizApp-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port (optional, for documentation purposes)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
