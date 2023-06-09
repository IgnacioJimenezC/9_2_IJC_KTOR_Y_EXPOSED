package com.example.DAO

import com.example.Entities.Articles
import com.example.Entities.Campos
import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.*
import org.jetbrains.exposed.sql.transactions.experimental.*

object DatabaseFactory {
    fun init() {
        val driverClassName = "org.h2.Driver"
        val jdbcURL = "jdbc:h2:./default"
        val database = Database.connect(jdbcURL, driverClassName,"user","user")
        transaction(database) {
            SchemaUtils.create(Articles)
            SchemaUtils.create(Campos)
        }
    }
    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }
}