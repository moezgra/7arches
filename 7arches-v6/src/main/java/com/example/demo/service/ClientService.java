
package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Client;

/**
 * Provide service for registering account 
 * @author raitis
 */
public interface ClientService {
    Client save(Client client);

    Client findByEmail(String email);
    
    List<Client> findAll();
}
