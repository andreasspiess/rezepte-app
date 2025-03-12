# Nutze das offizielle OpenJDK 17-Image als Basis
FROM openjdk:17-jdk-slim

# Setze das Arbeitsverzeichnis
WORKDIR /app

# Kopiere das JAR-File in den Container
COPY target/RezeptBuch-0.0.1-SNAPSHOT.jar app.jar

# Definiere den Startbefehl
ENTRYPOINT ["java", "-jar", "app.jar"]
