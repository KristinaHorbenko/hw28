package org.example;

import com.google.gson.Gson;
import org.example.status.StandardResponse;
import org.example.status.StatusResponse;

import java.sql.Timestamp;


import static org.example.Order.generateOrderId;
import static org.example.Product.generateProductId;
import static spark.Spark.get;
import static spark.Spark.post;

public class OrderController {


    public static void main(String[] args) {
        OrderRepository orderRepository = new OrderRepository();


        get("/order/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS,new Gson()
                            .toJsonTree(OrderRepository.getOrderById(Integer.parseInt(request.params(":id"))))));
        });

        //get all orders
        get("/order", (request, response) -> {
            response.type("application/json");
            return new Gson().toJsonTree(
            new StandardResponse(StatusResponse.SUCCESS,new Gson()
                    .toJsonTree(OrderRepository.getAllOrders())));

        });

        post("/order", (request, response) -> {
            response.type("application/json");
            Product product = new Gson().fromJson(request.body(), Product.class);

            product.setId(generateProductId());

            Order order = new Order();

            order.setId(generateOrderId());
            order.setDate(new Timestamp(System.currentTimeMillis()));

            order.getProducts().add(product);
            order.setCost(order.getProducts().stream().mapToDouble(Product::getCost).sum());

            orderRepository.addOrder(order);

            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS));


        });


    }
}
