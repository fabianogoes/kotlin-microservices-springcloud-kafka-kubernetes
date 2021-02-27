package br.com.eprogramar.order

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class OrderServiceApplication

fun main(args: Array<String>) {
	runApplication<OrderServiceApplication>(*args)
}
