package com.example.demo.service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.model.Client;
import com.example.demo.model.Role;

/**
 *Provide service for registering account 
 * @author raitis
 */
@Service
public class ClientServiceImpl implements ClientService{
 
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Client save(Client client) {
        client.setMotDePasse(bCryptPasswordEncoder.encode(client.getMotDePasse()));
        
        client.setRoles(new HashSet<Role>(roleRepository.findAll()));
        return clientRepository.save(client);
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

    
    
}
