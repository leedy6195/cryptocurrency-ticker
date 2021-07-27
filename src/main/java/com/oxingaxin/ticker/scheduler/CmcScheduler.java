package com.oxingaxin.ticker.scheduler;

import com.oxingaxin.ticker.model.TickerEntity;
import com.oxingaxin.ticker.model.coinmarketcap.CmcTickerApiResponse;
import com.oxingaxin.ticker.model.coinmarketcap.Currency;
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

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Transactional
public class CmcScheduler {

    private final RestTemplate restTemplate;
    private final TickerRepository tickerRepository;


    @Value("${api.coinmarketcap.key}")
    String apiKey;

    @Scheduled(fixedRate = 10000)
    public void schedule () {
        String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", apiKey);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("start", 1)
                .queryParam("limit", 2)
                .queryParam("convert", "USD");

        HttpEntity<?> request = new HttpEntity<>(headers);

        CmcTickerApiResponse cmcTickerApiResponse = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                request,
                new ParameterizedTypeReference<CmcTickerApiResponse>() {}
        ).getBody();

        /*
        String response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                request,
                String.class
        ).getBody();
         */
        tickerRepository.save(
                TickerEntity.builder()
                        .name(cmcTickerApiResponse.getData().get(1).getName())
                        .symbol(cmcTickerApiResponse.getData().get(1).getSymbol())
                        .slug(cmcTickerApiResponse.getData().get(1).getSlug())
                        .priceUsd(BigDecimal.valueOf(cmcTickerApiResponse.getData().get(1).getQuote().get(Currency.USD).getPrice()))
                        .build()
        );

    }
}
