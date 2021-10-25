package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Panier;

public interface PanierService {
	Panier save(Panier panier);
	
	Panier findByClient(Client client);
}
