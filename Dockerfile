# Use a lightweight Java Runtime Environment (JRE) for Java 21
FROM eclipse-temurin:21-jre

# Create a working directory inside the container
WORKDIR /app

# Copy the compiled .jar file from your target folder into the container
# This requires you to run './mvnw clean package' on your PC first!
COPY target/*.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# The command to start your application
ENTRYPOINT ["java", "-jar", "app.jar"]