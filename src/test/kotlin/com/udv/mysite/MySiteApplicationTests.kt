package com.udv.mysite

import com.udv.mysite.controller.IndexController
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootTest
class MySiteApplicationTests {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate
    lateinit var indexController: IndexController

    @Test
    fun contextLoads() {
        println("start===")
        var queryForList = jdbcTemplate.queryForList("show tables")
        println(queryForList)
    }

}
