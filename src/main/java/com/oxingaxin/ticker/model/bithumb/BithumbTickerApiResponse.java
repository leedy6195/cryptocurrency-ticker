package com.oxingaxin.ticker.model.bithumb;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oxingaxin.ticker.model.ApiResponse;
import com.oxingaxin.ticker.model.CryptoCurrency;
import com.oxingaxin.ticker.model.coinmarketcap.CmcTickerDTO;

import java.util.Map;

public class BithumbTickerApiResponse extends ApiResponse<BithumbTickerDTO, String> {
    @JsonCreator
    public BithumbTickerApiResponse(
            @JsonProperty("data") BithumbTickerDTO data,
            @JsonProperty("status") String metadata ) {
        super(data, metadata);
    }
}
