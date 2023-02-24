package com.devolpay.controller;

import com.devolpay.entity.Client;
import com.devolpay.service.impl.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/clients")
public class ClientController {

    @Autowired
    private ClientService serviceCliente;

    @PostMapping(value = "/save")
    public ResponseEntity<Client> saveCliente(@RequestBody Client cliente){
        try {
            Client cliente1 = serviceCliente.save(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(cliente1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
