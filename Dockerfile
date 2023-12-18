FROM maven:3.8.7-eclipse-temurin-19 as build
WORKDIR /app
COPY pom.xml .
COPY src/ src/
RUN mvn -f pom.xml clean install

FROM openjdk:19-jdk-oracle 

COPY --from=build /app/target/docker-demo.jar docker-demo.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","docker-demo.jar"]