FROM openjdk:11-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD target/myshop-0.0.1-SNAPSHOT.jar myapp.jar
ENTRYPOINT ["java", "-jar","/myapp.jar"]
