package com.oxingaxin.ticker.scheduler;

import com.oxingaxin.ticker.model.CryptoCurrency;
import com.oxingaxin.ticker.model.Market;
import com.oxingaxin.ticker.model.TickerEntity;
import com.oxingaxin.ticker.model.coinmarketcap.CmcTickerApiResponse;
import com.oxingaxin.ticker.model.Currency;
import com.oxingaxin.ticker.repository.TickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Transactional
public class CmcScheduler {

    private final RestTemplate restTemplate;
    private final TickerRepository tickerRepository;

    @Value("${api.coinmarketcap.key}")
    String apiKey;

    //@Scheduled(fixedRate = 1000 * 60 * 3)
    public void cmcTickerBtc () {
        cmcTicker(CryptoCurrency.BTC);
    }

    //@Scheduled(fixedRate = 1000 * 60 * 5)
    public void cmcTickerEth () {
        cmcTicker(CryptoCurrency.ETH);
    }

    public void cmcTicker (CryptoCurrency cryptoCurrency) {
        String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", apiKey);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("id", cryptoCurrency.getCmcId());

        HttpEntity<?> request = new HttpEntity<>(headers);

        CmcTickerApiResponse cmcTickerApiResponse = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<CmcTickerApiResponse>() {}
        ).getBody();

        tickerRepository.save(
                TickerEntity.builder()
                        .market(Market.CMC)
                        .name(cmcTickerApiResponse.getData().get(cryptoCurrency).getName())
                        .symbol(cmcTickerApiResponse.getData().get(cryptoCurrency).getSymbol())
                        .slug(cmcTickerApiResponse.getData().get(cryptoCurrency).getSlug())
                        .priceUsd(BigDecimal.valueOf(cmcTickerApiResponse.getData().get(cryptoCurrency).getQuote().get(Currency.USD).getPrice()))
                        .priceKrw(BigDecimal.ZERO)
                        .lastUpdated(cmcTickerApiResponse.getData().get(cryptoCurrency).getLastUpdated())
                        .build()
        );


        /*
        String response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                request,
                String.class
        ).getBody();

         */



    }
}
