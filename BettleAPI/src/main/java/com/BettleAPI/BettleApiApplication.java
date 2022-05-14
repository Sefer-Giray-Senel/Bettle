package com.BettleAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableConfigurationProperties
@EntityScan(basePackages = {"com.BettleAPI.entity"})
@ComponentScan(basePackages = {"com.BettleAPI"})
@EnableJpaRepositories(basePackages = {"com.BettleAPI.repository"})
@SpringBootApplication(exclude = { org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class BettleApiApplication {

	private static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		BettleApiApplication.applicationContext = SpringApplication.run(BettleApiApplication.class, args);
	}

}