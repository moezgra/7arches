package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Article;


public interface ArticleRepository extends JpaRepository<Article, Long> {
	List<Article> findByTitre(String titre);
}
