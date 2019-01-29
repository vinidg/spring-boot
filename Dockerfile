FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/springboot-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=tst", "-jar","/app.jar"]