## Eureka Server

References

- [Service Discovery: Eureka Server](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-eureka-server.html)
- [Microservices: Spring Cloud Eureka Server Configuration - dzone](https://dzone.com/articles/microservice-spring-cloud-eureka-server-configurat)

![Discover](../assets/spring-initializr-create-discover.png)

Set Annotation `@EnableEurekaServer`

```kotlin
package br.com.eprogramar.discover

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class DiscoverServerApplication

fun main(args: Array<String>) {
	runApplication<DiscoverServerApplication>(*args)
}

```

Set properties to configure as a Eureka Server

```properties
spring.application.name=DiscoverServer
eureka.client.serviceUrl.defaultZone=http://localhost:9091/eureka/
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

Name	| Description
------|------------
spring.application.name	              | Unique name for a Eureka server service.
eureka.client.serviceUrl.defaultZone  | It consults with other Eureka servers to sync the service registry. As it is in standalone mode, I am giving the local server address.
server.port                           |	In which port the server will be bound.
eureka.client.register-with-eureka    | This determines if this server registers itself as a client; as I said earlier, the Eureka server is also acting as a client so that it can sync the registry. The value being false means it prevents itself from acting as a client.
eureka.client.fetch-registry          | Does not register itself in the service registry.

 Now our Eureka server setup is complete.
 We will now run this project as a Java application. Now hit the following URL: http://localhost:8761. 
 You will see the following dashboard:

 ![Eureka dashboard](../assets/eukera-dashboard.png)


 ## Configure Eureka Client

At pom parent in microservices root add:

1. property:

```xml
  <properties>
    <spring-cloud.version>2020.0.1</spring-cloud.version>
  </properties>
```

2. Dependency Management

```xml
  <dependencyManagement>
    <dependencies>
      <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-dependencies</artifactId>
        <version>${spring-cloud.version}</version>
        <type>pom</type>
        <scope>import</scope>
      </dependency>
    </dependencies>
  </dependencyManagement>
```

3. Dependence

 ```xml
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
 ```

 After all configurations, In each microservices configure as Eureka Client:

 Fist add Annotation `@EnableDiscoveryClient` at Application Class

 ```kotlin
 package br.com.eprogramar.customer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class CustomerServiceApplication

fun main(args: Array<String>) {
	runApplication<CustomerServiceApplication>(*args)
}
```

Then add the properties 

```
spring.application.name=customer-service
server.port=8081
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

Now, first running the Eureka Server then running the Customer Service and look for Eureka Dashboard

![Customer Registered at Eureka](../assets/eukera-dashboard-customer-registered.png)

After configured and Running all the Microservices the Eureka Dashboard should look like this:

![All Service Registered](../assets/eukera-dashboard-all-service-registered.png)

[Eureka Client Reference](https://dzone.com/articles/spring-cloud-amp-spring-bootimplementing-eureka-se)