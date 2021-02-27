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
