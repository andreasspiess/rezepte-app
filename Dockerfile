# Build-Stage
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Package-Stage
FROM eclipse-temurin:17-jre AS runtime
WORKDIR /app
COPY --from=build /app/target/RezeptBuch-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
