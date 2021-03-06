package com.flightApp;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserUpdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserUpdateApplication.class, args);
	}

}
