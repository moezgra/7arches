package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Article;

@Service
public interface ArticleService {
	
	public List<Article> findAll();
	public Article findById(Long id);
	public List<Article> findByTitre(String titre);
	public void save(Article article);
	public void deleteById(Long id);
	public Article updateArticle(Article a);
	
	
}
