package com.oxingaxin.ticker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oxingaxin.ticker.model.Market;
import com.oxingaxin.ticker.model.TickerEntity;
import com.oxingaxin.ticker.repository.TickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Transactional
public class TickerController {

    private final TickerRepository tickerRepository;

    @GetMapping("/hello")
    public String hello(@RequestParam(value="name", defaultValue="World") String name) {
        return String.format("Hello %s!", name);
    }


    @GetMapping("/ticker/{marketName}/{coinSymbol}")
    public TickerEntity getTicker(
            @PathVariable("marketName") Market market,
            @PathVariable("coinSymbol") String coinSymbol) {
        return tickerRepository.findFirstByMarketAndSymbolIgnoreCaseOrderByCreatedDesc(market, coinSymbol).orElseThrow(null);
    }
}
