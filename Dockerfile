FROM openjdk:17
EXPOSE 8081
ADD target/*.jar spotifyclone-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/spotifyclone-0.0.1-SNAPSHOT.jar"]