package com.gp3.tonys;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gp3.tonys.db.entity.Product;
import com.gp3.tonys.repositories.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProductRepositoryIntegrationTest {

	@Autowired
	ProductRepository repository;

	@Autowired
	ReactiveMongoOperations operations;

	@BeforeEach
	public void setUp() {
		operations.collectionExists(Product.class)
				  .flatMap(exists -> exists ? operations.dropCollection(Product.class) : Mono.just(exists))
				  .flatMap(o -> operations.createCollection(Product.class, CollectionOptions.empty()))
				  .then()
				  .block();
		repository
				.saveAll(Flux.just(new Product("F_C", "Traditional Fish and Chips", "", "6.25"),
						new Product("Pizza", "Margherita", "The simple and good pizza", "6")))
				.then()
				.block();
	}

	@Test
	void findByNameAndPriceWithStringQueryTest() {
		Product fishAndChips = repository.findByNameAndPrice("Traditional Fish and Chips", "6.25")
										 .block();
		assertThat(fishAndChips).isNotNull();
	}

	@Test
	void findByNameAndPriceWithMonoQueryTest() {
		Product pizza = repository.findByNameAndPrice(Mono.just("Margherita"), "6")
								.block();
		assertThat(pizza).isNotNull();
	}

	@Test
	void findByNameWithStringQueryTest() {
		List<Product> tShirts = repository.findByName("T Shirt")
										  .collectList()
										  .block();
		assertThat(tShirts).isEmpty();
	}

	@Test
	void findByNameWithMonoQueryTest() {
		List<Product> tShirts = repository.findByName(Mono.just("T Shirt"))
										  .collectList()
										  .block();
		assertThat(tShirts).isEmpty();
	}

}
