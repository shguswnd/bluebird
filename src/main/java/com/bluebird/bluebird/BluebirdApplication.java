package com.bluebird.bluebird;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //Auditing 기능 활성화
public class BluebirdApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluebirdApplication.class, args);
	}

}