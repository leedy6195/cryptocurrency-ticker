package com.oxingaxin.ticker.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor
public class TickerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Market market;

    @Column
    private String name;

    @Column(nullable = false)
    private String symbol;

    @Column
    private String slug;

    @Column(columnDefinition = "decimal(20, 2)")
    private BigDecimal priceKrw = BigDecimal.valueOf(0.0);

    @Column(columnDefinition = "decimal(20, 4)")
    private BigDecimal priceUsd = BigDecimal.valueOf(0.0);

    @Column
    private Timestamp lastUpdated;

    @Column
    @CreationTimestamp
    private Timestamp created;

    @Builder
    public TickerEntity(Market market, String name, String symbol, String slug, BigDecimal priceKrw, BigDecimal priceUsd, Timestamp lastUpdated) {
        this.market = market;
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
        this.priceKrw = priceKrw;
        this.priceUsd = priceUsd;
        this.lastUpdated = lastUpdated;
    }

}
