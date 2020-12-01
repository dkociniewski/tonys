package com.gp3.tonys.db;

import com.gp3.tonys.db.dao.Dao;
import com.gp3.tonys.db.entity.Order;
import com.gp3.tonys.db.entity.OrderItem;
import com.gp3.tonys.db.entity.Product;

public interface DaoFacade {

	Dao<Product> getProductDao();

	Dao<OrderItem> getOrderItemDao();

	Dao<Order> getOrderDao();

}
