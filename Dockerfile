FROM openjdk:17
ADD target/hotelapi.jar  hotelapi-docker.jar
ENTRYPOINT [ "java","-jar","/hotelapi-docker.jar" ]