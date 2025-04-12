package dev.kimp.tracker.conflig.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "market")
public class CoinMarketProperties {
    private final MarketProperties upbit;
    private final MarketProperties binance;

    @ConstructorBinding
    public CoinMarketProperties(MarketProperties upbit, MarketProperties binance) {
        this.upbit = upbit;
        this.binance = binance;
    }

    public String getUpbitUri() {
        return upbit.getUri();
    }

    public long getUpbitInterval() {
        return upbit.getInterval();
    }

    public String getBinanceUri() {
        return binance.getUri();
    }

    public long getBinanceInterval() {
        return binance.getInterval();
    }

    @Getter
    public static class MarketProperties {
        private final String uri;
        private final long interval;

        @ConstructorBinding
        public MarketProperties(String uri, long interval) {
            this.uri = uri;
            this.interval = interval;
        }

        public String getUri() {
            return uri;
        }

        public long getInterval() {
            return interval;
        }
    }
}