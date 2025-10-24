FROM eclipse-temurin:21-jdk-jammy AS builder
WORKDIR /build
COPY . .
RUN chmod +x mvnw
RUN ./mvnw package -DskipTests

FROM gcr.io/distroless/java21-debian12
COPY --from=builder /build/target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]