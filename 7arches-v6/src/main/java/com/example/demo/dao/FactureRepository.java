package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {

}
