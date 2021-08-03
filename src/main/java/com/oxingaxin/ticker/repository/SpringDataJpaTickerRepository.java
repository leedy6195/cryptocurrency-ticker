package com.oxingaxin.ticker.repository;

import com.oxingaxin.ticker.model.TickerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaTickerRepository extends JpaRepository<TickerEntity, Long>, TickerRepository {

}
