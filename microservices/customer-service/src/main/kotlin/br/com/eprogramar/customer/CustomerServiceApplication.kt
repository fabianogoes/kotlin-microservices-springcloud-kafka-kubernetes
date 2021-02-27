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
