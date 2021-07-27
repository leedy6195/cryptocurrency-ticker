package com.oxingaxin.ticker.model.coinmarketcap;

public enum CmcCoinId {
    BTC(1),
    ETH(1027);

    private final int id;

    CmcCoinId(int id) {
        this.id = id;
    }
}
