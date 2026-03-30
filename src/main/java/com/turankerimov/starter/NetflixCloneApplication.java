package com.turankerimov.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages ={"com.turankerimov"})
@ComponentScan(basePackages = {"com.turankerimov"})
@EnableJpaRepositories(basePackages = {"com.turankerimov"})
@SpringBootApplication
public class NetflixCloneApplication {

	public static void main(String[] args) {

		SpringApplication.run(NetflixCloneApplication.class, args);
	}

}
