FROM openjdk:17-alpine
EXPOSE 8081
COPY target/hotelapi.jar  hotelapi-docker.jar
ENTRYPOINT [ "java","-jar","hotelapi-docker.jar" ]