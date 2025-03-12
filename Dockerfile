# Build-Stage
FROM maven:3.8.2-jdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Package-Stage
FROM openjdk:11-jdk-slim
COPY --from=build /target/RezeptBuch-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]
