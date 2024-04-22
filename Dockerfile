# Use an official Maven image to build the application
FROM maven:3.9.6-openjdk-19 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven dependency file
COPY pseudo_scene/pom.xml .

# Download the Maven dependencies
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY pseudo_scene/src ./src

# Build the application
RUN mvn package

# Use a lightweight JDK image to run the application
FROM adoptopenjdk/openjdk19:latest

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file built in the previous stage
COPY --from=builder /app/target/pseudo_scene-1.0-SNAPSHOT.jar .

# Specify the command to run your application when the container starts
CMD ["java", "-jar", "pseudo_scene-1.0-SNAPSHOT.jar"]

