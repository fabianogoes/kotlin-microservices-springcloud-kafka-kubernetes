package br.com.eprogramar.shipping

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class ShippingServiceApplication

fun main(args: Array<String>) {
	runApplication<ShippingServiceApplication>(*args)
}
