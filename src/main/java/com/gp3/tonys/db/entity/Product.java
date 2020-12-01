package com.gp3.tonys.db.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product implements Entity {
	@Id
	private String id;

	private String name;

	private String description;

	private String price;
}
