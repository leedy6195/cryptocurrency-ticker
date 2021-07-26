package com.oxingaxin.ticker.scheduler;

import com.oxingaxin.ticker.model.coinmarketcap.CmcTickerApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class CmcScheduler {

    private RestTemplate restTemplate;

    @Autowired
    public CmcScheduler (RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${api.coinmarketcap.key}")
    String apiKey;

    @Scheduled(fixedRate = 10000)
    public void schedule () {
        String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", apiKey);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("start", 1)
                .queryParam("limit", 1)
                .queryParam("convert", "USD");

        HttpEntity<?> request = new HttpEntity<>(headers);

        CmcTickerApiResponse response =
    }
}
