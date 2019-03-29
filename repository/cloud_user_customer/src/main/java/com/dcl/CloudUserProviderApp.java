package com.dcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudUserProviderApp {

	public static void main(String[] args) {
		SpringApplication.run(CloudUserProviderApp.class, args);
	}

}
