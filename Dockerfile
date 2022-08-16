FROM openjdk:18-jdk-alpine3.15
ADD target/siteScript-0.0.1-SNAPSHOT.jar siteScript.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","siteScript.jar"]