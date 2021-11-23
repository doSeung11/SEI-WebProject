package com.example.SE

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class SeApplication

fun main(args: Array<String>) {
	runApplication<SeApplication>(*args)
}
