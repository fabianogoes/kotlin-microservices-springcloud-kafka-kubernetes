# Docker

References

- [Dockerfile reference](https://docs.docker.com/engine/reference/builder/)

## Docker Image

```shell
FROM openjdk:8-jdk-alpine
EXPOSE 8761
ARG JAR_FILE=target/discover-server*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

## Build Image

```shell
docker build discover-server .
```

## Docker Run

```shell
docker run -it -p 8761:8761 discover-server:latest
```