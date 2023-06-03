package functionalendpoint

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class HoHandler {

    fun sayHo(request: ServerRequest) : Mono<ServerResponse> {
        return ServerResponse.ok().bodyValue("Ho~")
    }
}