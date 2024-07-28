package com.devsu.commons;

import java.util.List;

public interface DevsuCrudController<IN, OUT, K> {

    OUT create(IN entity);

    OUT update(K id, IN entity);

    void delete(K id);

    List<OUT> findAll();

    OUT findById(Long id);
}
