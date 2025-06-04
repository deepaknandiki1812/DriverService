FROM openjdk:17-jdk-slim
WORKDIR /driver
COPY target/*.jar Driver-0.0.1-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "Driver-0.0.1-SNAPSHOT.jar"]