package com.oxingaxin.ticker.model;

public enum Market {
    CMC("CoinMarketCap"),
    BITHUMB("Bithumb");

    String value;
    Market(String value) {
        this.value = value;
    }
}
