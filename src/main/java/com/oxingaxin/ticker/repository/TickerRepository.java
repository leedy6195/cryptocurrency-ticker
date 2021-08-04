package com.oxingaxin.ticker.repository;

import com.oxingaxin.ticker.model.Market;
import com.oxingaxin.ticker.model.TickerEntity;

import java.util.Optional;

public interface TickerRepository {
    TickerEntity save(TickerEntity tickerEntity);

    Optional<TickerEntity> findFirstByMarketAndSymbolIgnoreCaseOrderByCreatedDesc(Market market, String symbol);
}
