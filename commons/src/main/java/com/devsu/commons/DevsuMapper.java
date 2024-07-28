package com.devsu.commons;

public interface DevsuMapper<D, E> {
    E toEntity(D dto);
    D toDto(E entity);
}
