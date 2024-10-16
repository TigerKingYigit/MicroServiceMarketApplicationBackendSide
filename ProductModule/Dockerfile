FROM amazoncorretto:17

WORKDIR /app

COPY target/ProductModule-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
