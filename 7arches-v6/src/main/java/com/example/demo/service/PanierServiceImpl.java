package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PanierRepository;
import com.example.demo.model.Client;
import com.example.demo.model.Panier;

@Service
public class PanierServiceImpl implements PanierService {
	
	@Autowired
	private PanierRepository panierRepository;

	@Override
	public Panier save(Panier panier) {
		// TODO Auto-generated method stub
		return panierRepository.save(panier);
	}

	@Override
	public Panier findByClient(Client client) {
		// TODO Auto-generated method stub
		return panierRepository.findByClient(client);
	}

}
