package com.gp3.tonys.db.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.SerializationUtils;

import com.gp3.tonys.db.entity.Entity;

public class InMemoryDao<T extends Entity> implements Dao<T> {

	private final Map<String, T> data = new HashMap<>();

	private final Class<T> clazz;

	public InMemoryDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Optional<T> get(String id) {
		return Optional.ofNullable(data.get(id))
					   .map(SerializationUtils::clone);
	}

	@Override
	public List<T> getAll() {
		return data.values().stream()
				   .map(SerializationUtils::clone)
				   .collect(Collectors.toList());
	}

	@Override
	public void update(T t) {
		if (t != null) {
			if (t.getId() == null) {
				t.setId(RandomStringUtils.randomAlphanumeric(10));
			}
			data.put(t.getId(), t);
		}
	}

	@Override
	public void delete(T t) {
		if (t != null) {
			data.remove(t.getId());
		}
	}

	@Override
	public void deleteAll() {
		data.clear();
	}
}
