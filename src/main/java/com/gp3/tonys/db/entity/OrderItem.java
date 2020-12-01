package com.gp3.tonys.db.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class OrderItem implements Entity {
	@Id
	private String id;

	private Integer quantity;

	private Product product;

	private String price;

	public OrderItem(String id, Integer quantity, Product product) {
		this.id = id;
		this.quantity = quantity;
		this.product = product;

		this.price = new BigDecimal(product.getPrice())
				.multiply(BigDecimal.valueOf(quantity))
				.toString();
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}
}
