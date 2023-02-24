package com.devolpay.service;

import com.devolpay.config.ServiceConfig;
import com.devolpay.entity.Client;
import com.devolpay.service.impl.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ContextConfiguration(classes = { ServiceConfig.class })
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteServiceTest {

    @Autowired
    private ClientService clienteService;

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
        Client savedCliente =  clienteService.save(cliente);
        // assert that the saved Cliente instance matches the original
        assertEquals(cliente, savedCliente);
    }
}
