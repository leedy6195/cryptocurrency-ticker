package com.oxingaxin.ticker.repository;

import com.oxingaxin.ticker.model.TickerEntity;

public interface TickerRepository {
    TickerEntity save(TickerEntity tickerEntity);

    TickerEntity findBySymbol(String symbol);
}
