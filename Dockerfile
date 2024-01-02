FROM eclipse-temurin:21-alpine
WORKDIR /app
COPY /target/*.jar /app/app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "./app.jar"]