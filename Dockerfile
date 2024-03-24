FROM openjdk:17-jdk-alpine


ARG JAR_FILE=target/*.jar
COPY ./target/Exam2023-Traiteur-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
