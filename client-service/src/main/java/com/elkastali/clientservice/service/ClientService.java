package com.elkastali.clientservice.service;

import com.elkastali.clientservice.entities.Client;
import com.elkastali.clientservice.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }

    public void addClient(Client client) {
        clientRepository.save(client);
    }
}
