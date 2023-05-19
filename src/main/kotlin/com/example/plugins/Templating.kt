package com.example.plugins

import freemarker.cache.*
import io.ktor.server.freemarker.*
import io.ktor.server.application.*
import freemarker.core.*

fun Application.configureTemplating() {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
        outputFormat = HTMLOutputFormat.INSTANCE
    }
}
data class IndexData(val items: List<Int>)
