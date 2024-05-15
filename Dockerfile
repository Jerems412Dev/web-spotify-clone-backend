FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /spotifyclone
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /spotifyclone
COPY --from=build /spotifyclone/target/spotifyclone.jar /spotifyclone/spotifyclone.jar
EXPOSE 8081
CMD ["java", "-jar", "spotifyclone.jar"]
