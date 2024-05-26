package com.tarea.sem.dos.pooavance1.interfaces;

import java.util.List;

public interface IRepository <T> {
    List<T> findAll();
    void save(T model);
    T findById(String id);
}
