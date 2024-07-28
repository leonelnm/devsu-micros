package com.devsu;

public interface DevsuMapper<D, E> {
    E toEntity(D dto);
    D toDto(E entity);
}
