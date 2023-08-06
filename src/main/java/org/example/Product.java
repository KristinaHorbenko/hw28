package org.example;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Product {
    private static int productId = 0;

    private Integer id;
    private String name;
    private Double cost;


    public static int generateProductId() {
        return productId++;
    }
}


