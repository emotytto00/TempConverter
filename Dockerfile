# Use Maven image to build the project
FROM maven:latest AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and project files
COPY pom.xml /app/
COPY src /app/src/

# Build the project
RUN mvn clean package

# Use a smaller JRE image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from the Maven image
COPY --from=build /app/target/your-application.jar /app/your-application.jar

# Run the application
CMD ["java", "-jar", "your-application.jar"]
