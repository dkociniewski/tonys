package com.gp3.tonys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.mongodb.reactivestreams.client.MongoClient;

@Configuration
public class ReactiveMongoConfig {

	final MongoClient mongoClient;

	public ReactiveMongoConfig(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate() {
		return new ReactiveMongoTemplate(mongoClient, "test");
	}
}
