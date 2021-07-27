package com.oxingaxin.ticker.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Getter
@NoArgsConstructor
public class TickerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String symbol;

    @Column
    private String slug;

    @Column
    private BigDecimal priceKrw;

    @Column
    private BigDecimal priceUsd;

    @Column
    private Date lastUpdated;

    @Column
    @CreationTimestamp
    private Date created;

    @Builder
    public TickerEntity(String name, String symbol, String slug, BigDecimal priceKrw, BigDecimal priceUsd, Date lastUpdated) {
        this.name = name;
        this.symbol = symbol;
        this.slug = slug;
        this.priceKrw = priceKrw;
        this.priceUsd = priceUsd;
        this.lastUpdated = lastUpdated;
    }

}
