package org.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;



@Getter
@Setter
@Accessors(chain = true)
@ToString
public class Order {
    private static int orderId = 0;

    private Integer id;
    private Timestamp date;
    private Double cost;

    private List<Product> products = new ArrayList<>();

    public static int generateOrderId() {
        return orderId++;
    }
}











