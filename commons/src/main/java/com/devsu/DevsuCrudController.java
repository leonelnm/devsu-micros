package com.devsu;

import java.util.List;

public interface DevsuCrudController<T> {

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    List<T> findAll();

    T findById(Long id);
}
