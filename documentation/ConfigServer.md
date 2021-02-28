# Config Server

References

- [Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/reference/html/)
- [Intro to Spring Cloud Config Server - dzone](https://dzone.com/articles/intro-to-spring-cloud-config-server)
- [Microservices: Introduction to Spring Cloud Config Server and Config Client (Part 1)](https://springbootdev.com/2018/07/14/microservices-introduction-to-spring-cloud-config-server-with-client-examples/)

## Configuration Config Server Applications

1. Dependence

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
```

2. Annotation to Enable Config Server `@EnableConfigServer`

```kotlin
package com.eprogramar.config

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@EnableConfigServer
@SpringBootApplication
class ConfigServerApplication

fun main(args: Array<String>) {
	runApplication<ConfigServerApplication>(*args)
}
```

Set properties

```yml
spring:
  application:
    name: config-server
  cloud:
    config:
      discovery:
        enabled: true
      server:
        git:
          uri: https://github.com/fabianogoes/config-server-store.git

server:
  port: 9092

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka
```

> :warning: create a github repository with the name `config-server-store`
> exemplo to customer-service: customer-service.yml, customer-service-staging.yml, customer-service-production.yml

Now, we can running the Config Server Application


## Eureka Client

OK, then we go to do of Config Server as a Eurika Client:

1. Add dependency

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
</dependency>
```

2. create `bootstrap.yml`

```yml
eureka:
  client:
    serviceUrl:
      defaultZone: http://${DISCOVERY_SERVER_HOST:localhost}:8761/eureka

spring:
  profiles:
    active: default
  application:
    name: customer-service
  cloud:
    config:
      discovery:
        enabled: true
        service-id: config-server
```

3. create `application.yml`

```yml
app:
  messages:
    welcome: Welcome to Local

server:
  port: 8081

management:
  endpoints:
    web:
      exposure:
        include: '*'
  endpoint:
    health:
      show-details: always
```
