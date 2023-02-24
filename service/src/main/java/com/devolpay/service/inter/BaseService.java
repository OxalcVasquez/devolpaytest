package com.devolpay.service.inter;

import com.devolpay.entity.Client;

public interface BaseService<T> {

    T save(T entity);
}
