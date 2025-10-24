FROM openjdk:8

EXPOSE 8080

COPY app.jar /app/mu-core.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "/mu-core.jar"]