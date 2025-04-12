package dev.kimp.tracker.websocket.strategy;

import org.reactivestreams.Publisher;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public sealed interface CoinMarketSocketStrategy permits UpbitStrategyCoin, BinanceStrategyCoin {
    String getWebSocketUri();

    Publisher<WebSocketMessage> buildInitialMessage(WebSocketSession session);

    Flux<WebSocketMessage> buildScheduledMessages(WebSocketSession session);

    Mono<Void> handleMessage(String rawJson);
}
