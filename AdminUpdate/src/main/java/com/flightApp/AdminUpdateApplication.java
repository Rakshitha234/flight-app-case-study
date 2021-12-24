package com.flightApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminUpdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminUpdateApplication.class, args);
	}

}
