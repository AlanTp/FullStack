FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -v
RUN mvn clean install

FROM opnjdk17-jdk-slim

EXPOSE 8080

COPY --from=build /task-api/target/task-api-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java","-jar", "app.jar" ]