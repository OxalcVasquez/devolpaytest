package com.devolpay.dao;


import com.devolpay.config.MongoConfig;
import com.devolpay.dao.impl.ClientRepository;
import com.devolpay.entity.Client;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = { MongoConfig.class })
@RunWith(SpringRunner.class)
@DataMongoTest
public class TestCliente {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ClientRepository clienteRepository;

    @Test
    public void testSaveCliente() {
        // create a new Cliente instance
        Client cliente = new Client();
        cliente.setNombres("John");
        cliente.setApellidos("Doe");
        cliente.setDni("12345678");
        cliente.setTelefono("555-1234");
        cliente.setDireccion("123 Main St.");

        // save the Cliente instance using the repository
        clienteRepository.insert(cliente);

        // retrieve the Cliente instance from the database
        Client savedCliente = mongoTemplate.findById(cliente.getId(), Client.class);

        // assert that the saved Cliente instance matches the original
        assertEquals(cliente, savedCliente);
    }
}
