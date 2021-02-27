package br.com.eprogramar.product

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@EnableDiscoveryClient
@SpringBootApplication
class ProductServiceApplication

fun main(args: Array<String>) {
	runApplication<ProductServiceApplication>(*args)
}
