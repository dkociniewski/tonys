package com.gp3.tonys.db;

import com.gp3.tonys.db.dao.InMemoryDao;
import com.gp3.tonys.db.entity.Order;
import com.gp3.tonys.db.entity.OrderItem;
import com.gp3.tonys.db.entity.Product;

public class InMemoryDaoFacade extends AbstractDaoFacade {

	public InMemoryDaoFacade() {
		productDao = new InMemoryDao<>(Product.class);
		orderItemDao = new InMemoryDao<>(OrderItem.class);
		orderDao = new InMemoryDao<>(Order.class);
	}

}
