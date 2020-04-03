package com.gp3.tonys;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.gp3.tonys.models.Order;
import com.gp3.tonys.models.OrderItem;
import com.gp3.tonys.models.Product;

public class OrderPojoTest {
    @Test
    public void create() {
        Order order = new Order("1");
        assertTrue(order.getOrderItems().isEmpty());

        Product fishAndChips = new Product("1",
                "Fish And Chips",
                "Traditional Irish Fish and Chips",
                "4.90");
        OrderItem orderItem = new OrderItem("1", 2, fishAndChips);
        List<OrderItem> orderItems = List.of(orderItem);
        order.setOrderItems(orderItems);
        assertEquals("9.80", order.getOrderItems().get(0).getPrice());
    }
}
