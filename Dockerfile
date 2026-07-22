FROM maven:3.9.11-eclipse-temurin-21 AS builder
LABEL authors="Anatoly"
WORKDIR /notification
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /notification
COPY --from=builder /notification/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]