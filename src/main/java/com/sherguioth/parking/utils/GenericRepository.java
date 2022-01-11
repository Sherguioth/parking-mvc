package com.sherguioth.parking.utils;

public interface GenericRepository<T, ID> {

    T save(T t);

    void delete(T t);

    T find(ID id);

    T update(T t);

    Iterable<T> findAll();
}
