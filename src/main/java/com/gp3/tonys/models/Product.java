package com.gp3.tonys.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private String id;
    private String name;
    private String description;
    private String price;
}
