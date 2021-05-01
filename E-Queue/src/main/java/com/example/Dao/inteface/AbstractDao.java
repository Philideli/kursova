package com.example.Dao.inteface;

import com.example.model.MyQueue;

import java.util.Collection;

public interface AbstractDao<T> {
    T get(Integer id);
    Collection<T> findAll();
    void insert(T entity);
    MyQueue delete(Integer id);
}
