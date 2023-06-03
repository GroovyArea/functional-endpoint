package functionalendpoint

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
class Router {

    @Bean
    fun hoRouter(handler: HoHandler) : RouterFunction<ServerResponse> =
            route()
                    .GET("/", handler::sayHo)
                    .build()

    @Bean
    fun userRouter(handler: UserHandler) : RouterFunction<ServerResponse> =
            router {
                "/users".nest {
                    GET("/{id}",handler::getUser)
                    GET("", handler::getAll)
                }
            }
}