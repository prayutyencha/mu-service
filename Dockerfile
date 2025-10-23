FROM openjdk:8
EXPOSE 8080
ADD target/mu-core.jar mu-core.jar
ENTRYPOINT ["java", "-jar", "/mu-core.jar"]