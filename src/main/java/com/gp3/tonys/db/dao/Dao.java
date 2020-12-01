package com.gp3.tonys.db.dao;

import java.util.List;
import java.util.Optional;

import com.gp3.tonys.db.entity.Entity;

public interface Dao<T extends Entity> {

    Optional<T> get(String id);

    List<T> getAll();

    void update(T t);

    void delete(T t);

    void deleteAll();
}
