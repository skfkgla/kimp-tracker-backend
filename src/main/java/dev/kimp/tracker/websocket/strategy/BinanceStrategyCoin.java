package dev.kimp.tracker.websocket.strategy;

import dev.kimp.tracker.conflig.properties.CoinMarketProperties;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public final class BinanceStrategyCoin implements CoinMarketSocketStrategy {
    private final CoinMarketProperties coinMarketProperties;

    @Override
    public String getWebSocketUri() {
        return coinMarketProperties.getBinanceUri();
    }

    @Override
    public Publisher<WebSocketMessage> buildInitialMessage(WebSocketSession session) {
        return null;
    }

    @Override
    public Flux<WebSocketMessage> buildScheduledMessages(WebSocketSession session) {
        return null;
    }

    @Override
    public Mono<Void> handleMessage(String rawJson) {
        return null;
    }
}
