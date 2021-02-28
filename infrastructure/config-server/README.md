# Config Server

## Build 

```shell
mvn clean package
```

## Running with Maven

```shell
mvn spring-boot:run
```

## Running with Docker

```shell
mvn clean package && docker build -t config-server . && docker run -it -p 9092:9092 config-server
```