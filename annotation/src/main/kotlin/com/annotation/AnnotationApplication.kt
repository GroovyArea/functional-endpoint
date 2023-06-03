package com.annotation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AnnotationApplication {
}

fun main(args: Array<String>) {
    runApplication<AnnotationApplication>(*args)
}