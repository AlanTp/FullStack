# Stage 1: Build Stage
FROM ubuntu:latest AS build

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk maven

WORKDIR /app
COPY . .

RUN mvn clean install

# Stage 2: Runtime Stage
FROM mcr.microsoft.com/openjdk/jdk:17-distroless

EXPOSE 8080

COPY --from=build /app/target/task-api-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
