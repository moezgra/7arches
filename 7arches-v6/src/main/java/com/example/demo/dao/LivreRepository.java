package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {

}
