package com.gp3.tonys.db.entity;

import java.util.Collections;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Order implements Entity{
    @Id
    private String id;

    private List<OrderItem> orderItems;

    public Order(String id) {
        this.id = id;
        orderItems = Collections.emptyList();
    }
}

