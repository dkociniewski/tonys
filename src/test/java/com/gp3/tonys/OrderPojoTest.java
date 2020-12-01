package com.gp3.tonys;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.gp3.tonys.db.entity.Order;
import com.gp3.tonys.db.entity.OrderItem;
import com.gp3.tonys.db.entity.Product;

class OrderPojoTest {
    @Test
    void create() {
        Order order = new Order("1");
        assertTrue(order.getOrderItems().isEmpty());

        Product fishAndChips = new Product("F_C",
                "Fish And Chips",
                "Traditional Irish Fish and Chips",
                "4.90");
        OrderItem orderItem = new OrderItem("1", 2, fishAndChips);
        List<OrderItem> orderItems = List.of(orderItem);
        order.setOrderItems(orderItems);
        assertEquals("9.80", order.getOrderItems().get(0).getPrice());
    }
}
