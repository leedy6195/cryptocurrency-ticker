package com.oxingaxin.ticker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class TickerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String symbol;

    private String slug;

    private BigDecimal priceKrw;

    private BigDecimal priceUsd;

    private Date lastUpdated;

    private Date created;
}
