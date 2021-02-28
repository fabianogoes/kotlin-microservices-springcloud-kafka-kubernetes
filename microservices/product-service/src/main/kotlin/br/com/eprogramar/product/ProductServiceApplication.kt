package br.com.eprogramar.product

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
class ProductServiceApplication

fun main(args: Array<String>) {
	runApplication<ProductServiceApplication>(*args)
}

@RefreshScope
@RestController
@RequestMapping("/")
class WelcomeCustomerController(
	@Value("\${app.messages.welcome}") private val welcomeMessage: String
) {
	@GetMapping
	fun welcome(): String {
		return welcomeMessage
	}
}