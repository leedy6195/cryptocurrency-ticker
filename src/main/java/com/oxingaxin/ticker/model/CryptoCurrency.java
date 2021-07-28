package com.oxingaxin.ticker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CryptoCurrency {
    @JsonProperty("1") //coinmarketcap Id
    BTC("Bitcoin", "BTC", "bitcoin", "1"),

    @JsonProperty("1027") //coinmarketcap Id
    ETH("Ethereum", "ETH", "ethereum", "1027");

    final String name;
    final String symbol;
    final String slug;
    final String cmcId;
}
