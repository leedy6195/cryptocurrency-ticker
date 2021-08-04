package com.oxingaxin.ticker.repository;

import com.oxingaxin.ticker.model.Market;
import com.oxingaxin.ticker.model.TickerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaTickerRepository extends JpaRepository<TickerEntity, Long>, TickerRepository {

    TickerEntity save(TickerEntity tickerEntity);


    Optional<TickerEntity> findFirstByMarketAndSymbolIgnoreCaseOrderByCreatedDesc(Market market, String symbol);
}
