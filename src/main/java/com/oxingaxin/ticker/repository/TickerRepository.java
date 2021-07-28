package com.oxingaxin.ticker.repository;

import com.oxingaxin.ticker.model.Market;
import com.oxingaxin.ticker.model.TickerEntity;

public interface TickerRepository {
    TickerEntity save(TickerEntity tickerEntity);

    TickerEntity findByMarketAndSymbol(Market market, String symbol);
}
