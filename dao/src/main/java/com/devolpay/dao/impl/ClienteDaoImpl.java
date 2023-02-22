package com.devolpay.dao.impl;

import com.devolpay.config.ConfigMongo;
import com.devolpay.dao.inter.ClienteDaoInter;
import com.devolpay.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDaoImpl implements ClienteDaoInter {

    @Autowired
    @Qualifier(ConfigMongo.MONGODB)
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Cliente cliente) {
        mongoTemplate.insert(cliente,"cliente");
    }

    @Override
    public void update(Cliente cliente) {
        mongoTemplate.save(cliente,"cliente");
    }
}
