package com.oxingaxin.ticker.model.coinmarketcap;


import com.oxingaxin.ticker.model.ApiResponse;

import java.util.Map;

public class CmcTickerApiResponse extends ApiResponse<CmcTickerDTO> {
    public CmcTickerApiResponse(Map<String, Object> metadata, CmcTickerDTO data) {
        super(metadata, data);
    }
}
