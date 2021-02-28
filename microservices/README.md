# Microservices

- [Create Microservices](../documentation/CreateMicroservices.md)
- [Eureka Client](../documentation/EurekaClient.md)
- [Config Client](https://cloud.spring.io/spring-cloud-config/multi/multi__spring_cloud_config_client.html)
- [Spring Boot Actuator](https://howtodoinjava.com/spring-boot/actuator-endpoints-example/)

## Bootstrap Properties

To all microservices we'll to create a application.yml and a `bootstrap.yml`

It's very important to separete mutable properties into application 
and values that is required to application boot for example: Discover connection, Config Server Connection e etc. This values should be into `bootstrap.yml`

Values as Database connection, integrations url that can be variable for each profile/environemnt local, dev, prod. 
That's values should be into `application.yml` to be provided by Config Server in the Boot time.