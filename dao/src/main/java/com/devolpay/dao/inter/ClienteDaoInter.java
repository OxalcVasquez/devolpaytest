package com.devolpay.dao.inter;

import com.devolpay.entity.Cliente;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDaoInter {

    void insert(Cliente cliente);

    void update(Cliente cliente);

}
