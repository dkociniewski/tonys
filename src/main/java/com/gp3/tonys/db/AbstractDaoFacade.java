package com.gp3.tonys.db;

import com.gp3.tonys.db.dao.Dao;
import com.gp3.tonys.db.entity.Order;
import com.gp3.tonys.db.entity.OrderItem;
import com.gp3.tonys.db.entity.Product;

public abstract class AbstractDaoFacade implements DaoFacade {

	protected Dao<Product> productDao;

	protected Dao<OrderItem> orderItemDao;

	protected Dao<Order> orderDao;

	@Override
	public Dao<Product> getProductDao() {
		return productDao;
	}

	@Override
	public Dao<OrderItem> getOrderItemDao() {
		return orderItemDao;
	}

	@Override
	public Dao<Order> getOrderDao() {
		return orderDao;
	}
}
