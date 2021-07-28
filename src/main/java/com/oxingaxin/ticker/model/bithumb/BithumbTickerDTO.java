package com.oxingaxin.ticker.model.bithumb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BithumbTickerDTO {
    private final double priceKrw;
    private final Timestamp timestamp;

    @JsonCreator
    public BithumbTickerDTO(
            @JsonProperty("closing_price") double priceKrw,
            @JsonProperty("date") Timestamp timestamp) {
        this.priceKrw = priceKrw;
        this.timestamp = timestamp;
    }
}
