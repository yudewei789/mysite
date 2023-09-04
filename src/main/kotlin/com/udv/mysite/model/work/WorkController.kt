package com.udv.mysite.model.work

import com.udv.mysite.model.word.Work
import com.udv.mysite.model.word.WorkDao
import org.ktorm.dsl.eq
import org.ktorm.database.Database
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by vince on May 17, 2019.
 */
@RestController
class WorkController {
    @Autowired
    lateinit var workDao: WorkDao
    @Autowired
    lateinit var database: Database

    @GetMapping("/works/get-by-id")
    fun getWorkById(@RequestParam("id") id: Int): Work? {
        return workDao.findOne { it.id eq id }
    }

    @GetMapping("/works/get-all")
    fun getAllWorks(): List<Work> {
        return workDao.findAll()
    }

    @PostMapping("/works/create")
    fun createWork(
        @RequestParam("name") name: String,
        @RequestParam("location") location: String
    ): Work {
        val work = Work()
        work.name = name
        work.location = location
        workDao.add(work)
        return work
    }

    @PostMapping("/works/createTable")
    fun createTable(
        @RequestParam("name") name: String,
        @RequestParam("location") location: String
    ): Unit {
        //TODO auto create table

    }
}
