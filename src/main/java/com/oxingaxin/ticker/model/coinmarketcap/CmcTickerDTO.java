package com.oxingaxin.ticker.model.coinmarketcap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oxingaxin.ticker.model.Currency;
import lombok.Getter;



import java.sql.Timestamp;
import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CmcTickerDTO {
    private final long id;
    private final String name;
    private final String symbol;
    private final String slug;
    private final Timestamp lastUpdated;
    private final Map<Currency, PriceQuote> quote;

    @JsonCreator
    public CmcTickerDTO(@JsonProperty("id") long id,
                      @JsonProperty("name") String name,
                      @JsonProperty("symbol") String symbol,
                      @JsonProperty("slug") String slug,
                      @JsonProperty("last_updated") Timestamp lastUpdated,
                      @JsonProperty("quote") Map<Currency, PriceQuote> quote ){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
        this.lastUpdated = lastUpdated;
        this.quote = quote;
    }
}
