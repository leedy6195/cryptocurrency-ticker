package com.oxingaxin.ticker.util;

import com.oxingaxin.ticker.model.Market;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;


@Configuration
public class StringToMarketConverter implements Converter<String, Market> {
    @Override
    public Market convert(String source) {
        return Market.valueOf(source.toUpperCase());
    }
}
