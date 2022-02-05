FROM openjdk:11-jre-slim
ARG JAR_FILE_PATH=target/user-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE_PATH} user-service.jar

ENTRYPOINT ["java","-jar","/user-service.jar"]