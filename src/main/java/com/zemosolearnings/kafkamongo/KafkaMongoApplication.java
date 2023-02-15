package com.zemosolearnings.kafkamongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.zemosolearnings.kafkamongo.repository")
@ComponentScan("com.zemosolearnings.kafkamongo.*")
public class KafkaMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMongoApplication.class, args);
	}

}
