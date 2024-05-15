FROM openjdk:17
EXPOSE 8081
ADD target/*.jar spotifyclone.jar
ENTRYPOINT ["java","-jar","/spotifyclone.jar"]