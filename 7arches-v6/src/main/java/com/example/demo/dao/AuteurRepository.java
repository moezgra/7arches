package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {

}
