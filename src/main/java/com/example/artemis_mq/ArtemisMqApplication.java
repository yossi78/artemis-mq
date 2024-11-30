package com.example.artemis_mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EntityScan("com.example.artemis_mq.entity")
public class ArtemisMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtemisMqApplication.class, args);
	}

}
