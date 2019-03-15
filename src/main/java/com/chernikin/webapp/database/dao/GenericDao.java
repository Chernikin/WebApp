package com.chernikin.webapp.database.dao;

import java.sql.Connection;

public interface GenericDao<T> {

    // CRUD (create, read, update, delete)

    int create(Connection connection, T object);

    T getById(Connection connection, int id);

    T update(Connection connection, T object);

    void deleteById(Connection connection, int id);
}
