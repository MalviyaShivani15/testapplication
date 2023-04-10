FROM openjdk:11
ADD target/DBConfiguration-0.0.1-SNAPSHOT.jar DBConfiguration.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","DBConfiguration.jar"]