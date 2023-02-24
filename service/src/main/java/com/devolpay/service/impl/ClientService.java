package com.devolpay.service.impl;

import com.devolpay.dao.impl.ClientRepository;
import com.devolpay.entity.Client;
import com.devolpay.service.inter.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ClientService implements BaseService<Client> {

    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client save(Client cliente) {
        clientRepository.insert(cliente);
        return cliente;
    }
}
