package com.example.watchdog

import com.ecwid.consul.v1.ConsulClient
import com.ecwid.consul.v1.QueryParams
import com.ecwid.consul.v1.Response
import com.ecwid.consul.v1.agent.model.NewService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*


@SpringBootApplication
class WatchdogApplication : CommandLineRunner {

    companion object {
        val log = LoggerFactory.getLogger(WatchdogApplication::class.java)
    }

    override fun run(vararg args: String?) {
        log.debug("service started will register to consul now")

        val agentHost = "cs1"
        val agentPort = 8500

        val client = getClient(agentHost, agentPort)
        log.debug("consul client created")

        // register feed service
        val service = NewService()
        service.id = "feed"
        service.name = "feed"
        service.tags = Arrays.asList("EU-West", "EU-East")
        service.port = 8081
        registerService(client, service)
        client.agentServiceRegister(service)

        log.debug("service is now registered")

        val catalogService = client.getCatalogService("feed", QueryParams.DEFAULT)

        log.debug("regstered service from consul is ${catalogService.toString()}")

    }
}

fun getClient(agentHost: String, agentPort: Int): ConsulClient {
    return ConsulClient(agentHost, agentPort)
}

fun registerService(client: ConsulClient, service: NewService): Response<Void> {
    return client.agentServiceRegister(service)
}


fun main(args: Array<String>) {
    SpringApplication.run(WatchdogApplication::class.java, *args)
}
