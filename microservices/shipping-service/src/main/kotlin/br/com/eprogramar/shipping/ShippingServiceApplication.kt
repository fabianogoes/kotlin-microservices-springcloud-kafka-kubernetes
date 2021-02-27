package br.com.eprogramar.shipping

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShippingServiceApplication

fun main(args: Array<String>) {
	runApplication<ShippingServiceApplication>(*args)
}
