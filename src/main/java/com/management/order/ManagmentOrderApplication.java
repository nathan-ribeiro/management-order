package com.management.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ManagmentOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagmentOrderApplication.class, args);
	}

}
