FROM eclipse-temurin:21-alpine

WORKDIR /app

COPY /target/arcanix-core-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 3001

ENTRYPOINT ["java", "-jar", "app.jar"]