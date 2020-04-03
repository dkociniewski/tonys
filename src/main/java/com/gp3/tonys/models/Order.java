package com.gp3.tonys.models;

import java.lang.annotation.Documented;
import java.util.Collections;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Document
public class Order {
    private String id;

    private List<OrderItem> orderItems;

    public Order(String id) {
        this.id = id;
        orderItems = Collections.emptyList();
    }
}

