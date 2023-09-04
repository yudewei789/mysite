package com.udv.mysite.model.word

import org.ktorm.database.Database
import org.ktorm.entity.Entity
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

/**
 * The department entity.
 */
interface Work : Entity<Work> {
    companion object : Entity.Factory<Work>()

    /**
     * Department ID.
     */
    val id: Int

    /**
     * Department name.
     */
    var name: String

    /**
     * Department location.
     */
    var location: String
}

/**
 * The department table object.
 */
object Works : Table<Work>("t_work") {

    /**
     * Department ID.
     */
    val id = int("id").primaryKey().bindTo { it.id }

    /**
     * Department name.
     */
    val name = varchar("name").bindTo { it.name }

    /**
     * Department location.
     */
    val location = varchar("location").bindTo { it.location }
}

/**
 * Return a default entity sequence of [Departments].
 */
val Database.works get() = this.sequenceOf(Works)
