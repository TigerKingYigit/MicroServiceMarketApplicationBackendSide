FROM amazoncorretto:17

WORKDIR /app

COPY target/RaporModule-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]
