package com.udv.mysite.model.word

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
class WordController {
    @Autowired
    lateinit var wordDao: WordDao
    @Autowired
    lateinit var database: Database

    @GetMapping("/words/get-by-id")
    fun getWordById(@RequestParam("id") id: Int): Word? {
        return wordDao.findOne { it.id eq id }
    }

    @GetMapping("/words/get-all")
    fun getAllWords(): List<Word> {
        return wordDao.findAll()
    }

    @PostMapping("/words/create")
    fun createWord(
        @RequestParam("name") name: String,
        @RequestParam("location") location: String
    ): Word {
        val word = Word()
        word.name = name
        word.location = location
        wordDao.add(word)
        return word
    }

    @PostMapping("/words/createTable")
    fun createTable(
        @RequestParam("name") name: String,
        @RequestParam("location") location: String
    ): Unit {
        //TODO auto create table

    }
}
