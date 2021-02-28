# Docker Compose

References

- [Overview of Docker Compose](https://docs.docker.com/compose/)

## Infrastructure Example

```shell
version: "3.9"

networks:
  wakanda: {}

services:
  discover-service:
    container_name: discover-service
    build:
      context: ./discover-server
      dockerfile: Dockerfile
    networks:
      - wakanda
    ports:
      - "8761:8761"
    init: true
    environment:
      - "EUREKA_SERVER_HOST=discover-service"
  config-server:
    container_name: config-server
    build:
      context: ./config-server
      dockerfile: Dockerfile
    depends_on:
      - discover-service
    networks:
      - wakanda
    ports:
      - "9092:9092"
    healthcheck:
      test: [ "CMD", "curl", "-f", "http://discover-service:8761/eureka" ]
      interval: 1m30s
      timeout: 10s
      retries: 10
      start_period: 40s
    environment:
      - "EUREKA_SERVER_HOST=discover-service"
```

## Microservices Example

```shell
version: "3.9"
services:
  discover-service:
    container_name: discover-service
    build:
      context: ../infrastructure/discover-server
      dockerfile: Dockerfile
    ports:
      - "8761:8761"
    init: true
    environment:
      - "EUREKA_SERVER_HOST=discover-service"
  config-server:
    container_name: config-server
    build:
      context: ../infrastructure/config-server
      dockerfile: Dockerfile
    depends_on:
      - discover-service
    ports:
      - "9092:9092"
    restart: always
    environment:
      - "EUREKA_SERVER_HOST=discover-service"
  customer-service:
    container_name: customer-service
    build:
      context: ./customer-service
      dockerfile: Dockerfile
    depends_on:
      - discover-service
      - config-server
    ports:
      - "8081:8081"
    init: true
    environment:
      - "EUREKA_SERVER_HOST=discover-service"
      - "CONFIG_SERVER_HOST=config-server"
```