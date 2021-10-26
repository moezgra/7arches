package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.model.Article;
import com.example.demo.model.LivrePapier;
import com.example.demo.service.ArticleService;

@Controller
public class ArticleController {
	// injecter le repository
//		@Autowired
//		private ArticleRepository articleRepository; 
		@Autowired
		ArticleService articleService;
		
		// afficher la liste des articles
		@GetMapping({"/showArticles", "/"})
		public String showArticles(Model model, HttpServletRequest request) {
			List<Article> articles = articleService.findAll();
			model.addAttribute("articles", articles);
			
			return "showArticles";
		} 
		
		// afficher un seul article
		@GetMapping("/showArticle/{id}")
		public String showArticle(@PathVariable Long id, Model model) {
			model.addAttribute("article", articleService.findById(id));
					//articleRepository.findById(id).orElse(null));
			return "showArticle";
		}
		
		// Chercher un article par titre
		@PostMapping("/showArticlesByTitre")
		public String showArticleByTitre(@RequestParam String titre, Model model) {
			ArrayList <Article> articles = (ArrayList<Article>) articleService.findByTitre(titre);
			model.addAttribute("articles", articles);
			return "showArticleByTitre";
		}
		
		
		
}
		
		


