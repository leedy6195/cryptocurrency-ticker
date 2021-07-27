package com.oxingaxin.ticker.model.coinmarketcap;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oxingaxin.ticker.model.ApiResponse;

import java.util.List;
import java.util.Map;

public class CmcTickerApiResponse extends ApiResponse<List<CmcTickerDTO>> {
    @JsonCreator
    public CmcTickerApiResponse(
            @JsonProperty("data") List<CmcTickerDTO> data,
            @JsonProperty("status") Map<String, Object> metadata
        ) {
        super(data, metadata);
    }
}
