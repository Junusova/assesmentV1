

FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /demo/demo.jar
ENTRYPOINT ["java","-Dspring.profiles.active=test" , "-jar","/demo/demo.jar"]