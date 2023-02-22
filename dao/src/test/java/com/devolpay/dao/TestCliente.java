package com.devolpay.dao;


import com.devolpay.config.ConfigMongo;
import com.devolpay.dao.impl.ClienteDaoImpl;
import com.devolpay.entity.Cliente;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = { ConfigMongo.class })
@RunWith(SpringRunner.class)
@DataMongoTest
public class TestCliente {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ClienteDaoImpl clienteRepository;

    @Before
    public void setUp() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigMongo.class);
        clienteRepository = context.getBean(ClienteDaoImpl.class);
    }

    @Test
    public void testSaveCliente() {
        // create a new Cliente instance
        Cliente cliente = new Cliente();
        cliente.setNombres("John");
        cliente.setApellidos("Doe");
        cliente.setDni("12345678");
        cliente.setTelefono("555-1234");
        cliente.setDireccion("123 Main St.");

        // save the Cliente instance using the repository
        clienteRepository.insert(cliente);

        // retrieve the Cliente instance from the database
        Cliente savedCliente = mongoTemplate.findById(cliente.getId(), Cliente.class);

        // assert that the saved Cliente instance matches the original
        assertEquals(cliente, savedCliente);
    }
}
