package com.flightApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UsersConfiguration {

	@Bean
	public RestTemplate getRestAPITemplate() {
		return new RestTemplate();
	}
}
