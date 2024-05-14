FROM openjdk:17
EXPOSE 8081
ADD target/*.jar sspotifyclone.jar
ENTRYPOINT ["java","-jar","/spotifyclone.jar"]