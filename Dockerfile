# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/your-application.jar app.jar

# Expose the application port (optional, for documentation purposes)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]