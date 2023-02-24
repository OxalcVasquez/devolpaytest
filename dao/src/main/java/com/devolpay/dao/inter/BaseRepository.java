package com.devolpay.dao.inter;

import com.devolpay.entity.Client;

public interface BaseRepository<T> {

    void insert(T entity);

    void update(T entity);

}
