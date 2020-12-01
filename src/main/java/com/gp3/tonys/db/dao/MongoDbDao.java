package com.gp3.tonys.db.dao;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.gp3.tonys.db.entity.Entity;

import dev.morphia.Datastore;
import dev.morphia.query.Query;

public class MongoDbDao<T extends Entity> implements Dao<T> {

	private Datastore datastore;

	private Class<T> clazz;

	public MongoDbDao(Datastore datastore, Class<T> clazz) {
		this.datastore = datastore;
		this.clazz = clazz;
	}

	@Override
	public Optional<T> get(String id) {
		return Optional.ofNullable(datastore.find(clazz).filter("_id =", id).first());
	}

	@Override
	public List<T> getAll() {
		Query<T> query = datastore.find(clazz);
		return query.find().toList();
	}

	@Override
	public void update(T t) {
		if (t.getId() == null) {
			t.setId(new ObjectId().toHexString());
		}
		datastore.save(t);
	}

	@Override
	public void delete(T t) {
		datastore.delete(t);
	}

	@Override
	public void deleteAll() {
		getAll().forEach(this::delete);
	}
}
