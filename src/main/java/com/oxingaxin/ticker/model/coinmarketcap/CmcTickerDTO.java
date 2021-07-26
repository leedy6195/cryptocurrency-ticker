package com.oxingaxin.ticker.model.coinmarketcap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CmcTickerDTO {
    private long id;
    private String name;
    private String symbol;
    private String slug;
    private Date lastUpdated;
    private Map<Currency, PriceQuote> quote;

    @JsonCreator
    public CmcTickerDTO(@JsonProperty("id") long id,
                      @JsonProperty("name") String name,
                      @JsonProperty("symbol") String symbol,
                      @JsonProperty("slug") String slug,
                      @JsonProperty("last_updated") Date lastUpdated,
                      @JsonProperty("quote") Map<Currency, PriceQuote> quote ){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
        this.lastUpdated = lastUpdated;
        this.quote = quote;
    }
}
