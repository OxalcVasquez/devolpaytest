package com.devolpay.dao.impl;

import com.devolpay.config.MongoConfig;
import com.devolpay.dao.inter.BaseRepository;
import com.devolpay.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan
public class ClientRepository implements BaseRepository<Client> {

    @Autowired
    @Qualifier(MongoConfig.MONGODB)
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(Client cliente) {
        mongoTemplate.insert(cliente,"cliente");
    }

    @Override
    public void update(Client cliente) {
        mongoTemplate.save(cliente,"cliente");
    }
}
