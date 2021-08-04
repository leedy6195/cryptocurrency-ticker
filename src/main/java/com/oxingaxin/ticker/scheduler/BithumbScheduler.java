package com.oxingaxin.ticker.scheduler;

import com.oxingaxin.ticker.model.CryptoCurrency;
import com.oxingaxin.ticker.model.Market;
import com.oxingaxin.ticker.model.TickerEntity;
import com.oxingaxin.ticker.model.bithumb.BithumbTickerApiResponse;
import com.oxingaxin.ticker.repository.TickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Transactional
public class BithumbScheduler {

    private final RestTemplate restTemplate;
    private final TickerRepository tickerRepository;

    //@Scheduled(fixedRate = 1000 * 60 * 3)
    public void bithumbTickerEth() {
        bithumbTicker(CryptoCurrency.ETH);
    }

    public void bithumbTicker (CryptoCurrency cryptoCurrency) {
        String uri = String.format("https://api.bithumb.com/public/ticker/%s_KRW", cryptoCurrency);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
        HttpEntity<?> request = new HttpEntity<>(new HttpHeaders());

        BithumbTickerApiResponse bithumbTickerApiResponse = restTemplate.exchange(
            builder.toUriString(),
            HttpMethod.GET,
            request,
            new ParameterizedTypeReference<BithumbTickerApiResponse>() {}
        ).getBody();
        if(bithumbTickerApiResponse != null) {
            tickerRepository.save(
                TickerEntity.builder()
                .market(Market.BITHUMB)
                .name(cryptoCurrency.getName())
                .symbol(cryptoCurrency.getSymbol())
                .slug(cryptoCurrency.getSlug())
                .priceUsd(BigDecimal.ZERO)
                .priceKrw(BigDecimal.valueOf(bithumbTickerApiResponse.getData().getPriceKrw()))
                .build()
            );
        }
        

    }
}
