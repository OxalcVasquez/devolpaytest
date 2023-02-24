package com.devolpay.controller;

import com.devolpay.config.ControllerConfig;
import com.devolpay.entity.Client;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ContextConfiguration(classes = { ControllerConfig.class })
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSaveClient() throws Exception {
        Client client = new Client();
        client.setNombres("Test Client");
        client.setDireccion("testclient@test.com");

        ResponseEntity<Client> response = restTemplate.postForEntity("/api/clients/save", client, Client.class);
        assertEquals("Test",HttpStatus.CREATED, response.getStatusCode());
        Client createdClient = response.getBody();
        assertNotNull(createdClient.getId());
        assertEquals("The client name is incorrect","Test Client", createdClient.getNombres());
        assertEquals("The client email address is incorrect","testclient@test.com", createdClient.getDireccion());
    }

}
