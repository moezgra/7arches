package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.LivreNumerique;

public interface LigneNumeriqueRepository extends JpaRepository<LivreNumerique, Long> {

}
