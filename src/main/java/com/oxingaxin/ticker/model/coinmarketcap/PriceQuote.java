package com.oxingaxin.ticker.model.coinmarketcap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceQuote {
    private double price;

    @JsonCreator
    public PriceQuote(@JsonProperty("price") double price) {
        this.price = price;
    }
}
