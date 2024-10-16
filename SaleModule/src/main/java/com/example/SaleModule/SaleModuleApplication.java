package com.example.SaleModule;

import com.example.SaleModule.Models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

@SpringBootApplication
public class SaleModuleApplication {


	public static void main(String[] args) {
		SpringApplication.run(SaleModuleApplication.class, args);


	}
	@Bean
	public WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}


}
