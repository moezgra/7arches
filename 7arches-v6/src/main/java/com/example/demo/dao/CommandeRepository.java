package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
