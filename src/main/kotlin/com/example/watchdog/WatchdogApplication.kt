package com.example.watchdog

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WatchdogApplication

fun main(args: Array<String>) {
    SpringApplication.run(WatchdogApplication::class.java, *args)
}
