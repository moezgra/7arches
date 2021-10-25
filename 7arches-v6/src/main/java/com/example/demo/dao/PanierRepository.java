package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Client;
import com.example.demo.model.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long> {
	Panier findByClient(Client client);
}
