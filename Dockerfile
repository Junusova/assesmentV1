
FROM openjdk:8-jdk-alpine

EXPOSE 9092


COPY build/libs/demo-0.0.1-SNAPSHOT.jar /demo/demo.jar

CMD ["java","-jar","/demo/demo.jar"]