package net.es.oscars.web;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

// https://stackoverflow.com/questions/45147280/
@Component
public class IndexController implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        if (exchange.getRequest().getURI().getPath().equals("/")) {
            return chain.filter(exchange.mutate().request(exchange.getRequest().mutate().path("/index.html").build()).build());
        }

        return chain.filter(exchange);
    }
}