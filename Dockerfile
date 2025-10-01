FROM eclipse-temurin:25-jdk AS build
LABEL authors="Fernando Lopes"

WORKDIR /app

COPY pom.xml .
COPY .mvn .
COPY mvnw .

RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:25-jre

WORKDIR /app

COPY --from=build /app/targe/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]