package com.example.watchdog

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

/**
 * @author kumarsambhav.jain
 * @since  7/14/2017.
 */
@RestController
class Controller {

    companion object {
        val log = LoggerFactory.getLogger(Controller::class.java)
    }

    @GetMapping("/")
    fun hello(): Map<String, String> {
        val s = UUID.randomUUID().toString()
        val d: Int = (Math.random() * 10000 % 3).toInt()
        when (d) {
            0 -> log.info("cloudwatch should see this $s")
            1 -> log.debug("cloudwatch should see this $s")
            2 -> log.error("cloudwatch should see this $s")
        }
        return mapOf("Hello" to "World $s Green Deployement v3.0 with brand new features")
    }


    @GetMapping
    fun helloAny(): Map<String, String> {
        val s = UUID.randomUUID().toString()
        val d: Int = (Math.random() * 10000 % 3).toInt()
        when (d) {
            0 -> log.info("any non-root url $s")
            1 -> log.debug("any non-root url $s")
            2 -> log.error("any non-root url $s")
        }
        return mapOf("Hello any non-root url" to "World $s Green Deployment v3.0")
    }
}