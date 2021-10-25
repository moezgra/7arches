package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
