package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.model.Article;
import com.example.demo.model.LivrePapier;

@Service
public class ArticleServiceImpl implements ArticleService {
	//*Injection de dependances*/
	@Autowired
	ArticleRepository articleRepository;

	@Override
	public List<Article> findAll() {
		return articleRepository.findAll();
	}

	@Override
	public Article findById(Long id) {
		return articleRepository.findById(id).get();
	}
	
	@Override
	public List<Article> findByTitre(String titre) {
		return articleRepository.findByTitre(titre);
	}
	

	@Override
	public void save(Article article) {
		// verif de l'article avant la sauvegarde
		
		
		articleRepository.save(article);
		
	}

	@Override
	public void deleteById(Long id) {
		articleRepository.deleteById(id);
		
	}
	@Override
	public Article updateArticle(Article article) {
		return articleRepository.save(article);
	}

	


}
