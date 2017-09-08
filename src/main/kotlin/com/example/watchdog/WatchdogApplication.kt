package com.example.watchdog

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.system.ApplicationPidFileWriter


@SpringBootApplication
class WatchdogApplication

fun main(args: Array<String>) {
    val application = SpringApplication(WatchdogApplication::class.java)
    application.addListeners(ApplicationPidFileWriter("watchdog.pid"))
    application.run(*args)
}
