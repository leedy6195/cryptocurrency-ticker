package com.oxingaxin.ticker.model.coinmarketcap;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oxingaxin.ticker.model.ApiResponse;
import com.oxingaxin.ticker.model.CryptoCurrency;

import java.util.List;
import java.util.Map;

public class CmcTickerApiResponse extends ApiResponse<Map<CryptoCurrency, CmcTickerDTO>, Map<String, Object>> {
    @JsonCreator
    public CmcTickerApiResponse(
            @JsonProperty("data") Map<CryptoCurrency, CmcTickerDTO> data,
            @JsonProperty("status") Map<String, Object> metadata
        ) {
        super(data, metadata);
    }
}
