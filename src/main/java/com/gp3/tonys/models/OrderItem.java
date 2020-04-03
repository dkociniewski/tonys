package com.gp3.tonys.models;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Document
public class OrderItem {
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
}
