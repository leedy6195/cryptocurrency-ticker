package com.oxingaxin.ticker.config;

import com.oxingaxin.ticker.model.Market;
import com.oxingaxin.ticker.repository.SpringDataJpaTickerRepository;
import com.oxingaxin.ticker.repository.TickerRepository;
import com.oxingaxin.ticker.util.StringToMarketConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;


@Configuration
public class AppConfig {

    @Bean
    public Converter<String, Market> stringMarketConverter() {
        return new StringToMarketConverter();
    }


}
