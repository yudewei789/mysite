package com.udv.mysite

import io.github.oshai.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.core.env.Environment
import java.net.InetAddress

@SpringBootApplication
class MySiteApplication : SpringBootServletInitializer()
private val logger = KotlinLogging.logger {}
fun main(args: Array<String>) {
    var application = runApplication<MySiteApplication>(*args)
    val env: Environment = application.environment
    val ip = InetAddress.getLocalHost().hostAddress
    val port = env.getProperty("server.port")
    val path: String? = env.getProperty("server.servlet.context-path")
    val userDir = System.getProperty("user.dir")
    logger.info(
        "\n----------------------------------------------------------\n\t" +
                "Application Jeecg-Boot is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "Swagger文档: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "userDir: " + userDir + "\n" +
                "----------------------------------------------------------"
    )
}
