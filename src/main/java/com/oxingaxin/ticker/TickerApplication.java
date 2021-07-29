package com.oxingaxin.ticker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oxingaxin.ticker.model.Market;
import com.oxingaxin.ticker.model.TickerEntity;
import com.oxingaxin.ticker.repository.JpaTickerRepository;
import com.oxingaxin.ticker.repository.TickerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@SpringBootApplication
@EnableScheduling
public class TickerApplication {


	public static void main(String[] args) {
		SpringApplication.run(TickerApplication.class, args);
	}


}
