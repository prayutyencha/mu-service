FROM openjdk:8

EXPOSE 8080

WORKDIR /app

COPY target/mu-core.jar /app/mu-core.jar

ENTRYPOINT ["java", "-jar", "/mu-core.jar"]