FROM openjdk:17
WORKDIR /app
COPY target/RezeptBuch.jar app.jar
CMD ["java", "-jar", "app.jar"]
