package com.gp3.tonys.db;

import com.gp3.tonys.db.dao.MongoDbDao;
import com.gp3.tonys.db.entity.Order;
import com.gp3.tonys.db.entity.OrderItem;
import com.gp3.tonys.db.entity.Product;

import dev.morphia.Datastore;

public class MongoDbDaoFacade extends AbstractDaoFacade {

	public MongoDbDaoFacade(Datastore datastore) {
		productDao = new MongoDbDao<>(datastore, Product.class);
		orderItemDao = new MongoDbDao<>(datastore, OrderItem.class);
		orderDao = new MongoDbDao<>(datastore, Order.class);
	}
}
