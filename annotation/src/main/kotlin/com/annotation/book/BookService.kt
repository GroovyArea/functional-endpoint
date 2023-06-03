package com.annotation.book

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.concurrent.atomic.AtomicInteger

data class Book(
        val id: Int,
        val name: String,
        val price: Int
)

@Service
class BookService {

    private final val nextId = AtomicInteger(0)

    val books = mutableListOf(
            Book(nextId.incrementAndGet(), "코틀린 인 액션", 30000),
            Book(nextId.incrementAndGet(), "이펙티브 코틀린", 20000),
            Book(nextId.incrementAndGet(), "HTTP 완벽 가이드", 40000),
    )

    fun getAll(): Flux<Book> {
        return Flux.fromIterable(books)
    }

    fun get(id: Int): Mono<Book> {
        return Mono.justOrEmpty(books.find { it.id == id })
    }

    fun add(request: Map<String, Any>): Mono<Book> {
        return Mono.just(request)
                .map {
                    val newBook = Book(
                            id = nextId.incrementAndGet(),
                            name = request["name"].toString(),
                            price = request["price"] as Int,
                    )

                    books.add(newBook)
                    newBook
                }
    }

    fun delete(id: Int): Mono<Void> {
        return Mono.justOrEmpty(books.find { it.id == id })
                .map { books.remove(it) }
                .then()
    }
}