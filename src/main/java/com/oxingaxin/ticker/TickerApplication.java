package com.oxingaxin.ticker;

import com.oxingaxin.ticker.model.Market;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
public class TickerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TickerApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value="name", defaultValue="World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/ticker/{marketName}/{coinSymbol}")
	public String ticker(
			@PathVariable("marketName") Market market,
			@PathVariable("coinSymbol") String coinSymbol) {
		return "";
	}
	/*
	@GetMapping("/ticker/{coinType}")
	public String ticker(@PathVariable("coinType") String coinType){

	}
	*/


}
