package com.gp3.tonys.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.gp3.tonys.db.entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, String> {
	Flux<Product> findByName(String name);

	Flux<Product> findByName(Mono<String> name);

	Mono<Product> findByDescription(Mono<String> description);

	Mono<Product> findByNameAndPrice(String name, String price);

	Mono<Product> findByNameAndPrice(Mono<String> name, String price);
}
