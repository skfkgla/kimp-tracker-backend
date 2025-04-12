package dev.kimp.tracker.websocket.strategy;

import dev.kimp.tracker.conflig.properties.CoinMarketProperties;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public final class UpbitStrategyCoin implements CoinMarketSocketStrategy {

    private final CoinMarketProperties coinMarketProperties;

    @Override
    public String getWebSocketUri() {
        return coinMarketProperties.getUpbitUri();
    }


    @Override
    public Publisher<WebSocketMessage> buildInitialMessage(WebSocketSession session) {
        String msg = "[{\"ticket\":\"upbit\"},{\"type\":\"ticker\",\"codes\":[\"KRW-BTC\"]}]";
        return Mono.just(session.textMessage(msg));
    }

    @Override
    public Flux<WebSocketMessage> buildScheduledMessages(WebSocketSession session) {
        return Flux.interval(Duration.ofSeconds(coinMarketProperties.getUpbitInterval()))
                .map(i -> session.textMessage("{\"type\":\"ping\"}"));
    }

    @Override
    public Mono<Void> handleMessage(String rawJson) {
        return null;
    }
}
