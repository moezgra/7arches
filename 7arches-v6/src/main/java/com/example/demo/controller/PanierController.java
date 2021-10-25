package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.model.Client;
import com.example.demo.model.LignePanier;
import com.example.demo.model.Panier;
import com.example.demo.service.ClientService;
import com.example.demo.service.PanierService;

@Controller
public class PanierController {
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private PanierService panierService;

	@GetMapping(value = "/showPanier")
	public String showPanier(Model model, WebRequest request) {
		
		// Get login user information
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		// Get authenticated user name - in this case, it means email
//		String email = auth.getName();
//		System.out.println("Email : " + email);
//		
//		List<String> emails = new LinkedList<>();
//		
//		clientService.findAll().forEach(c->{
//			emails.add(c.getEmail());
//		});
//		
//		if (!emails.contains(email)) {
//			return "redirect:/login";
//		}
//		
//		// Get Client instance by email
//		Client client = clientService.findByEmail(email);
		
		Panier panier = (Panier) request.getAttribute("panier", request.SCOPE_SESSION);	
		
		//Panier panier = panierService.findByClient(client);
			
		
		
		model.addAttribute("panier", panier);
		return "panier";
	}

	@PostMapping(value = "/addArticle")
	public String addArticle(@RequestParam long id, Model model, WebRequest request) {
		
//		// Get login user information
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		// Get authenticated user name - in this case, it means email
//		String email = auth.getName();
//		
//		List<String> emails = new LinkedList<>();
//		
//		clientService.findAll().forEach(c->{
//			emails.add(c.getEmail());
//		});
//		
//		if (!emails.contains(email)) {
//			return "redirect:/login";
//		}	
//		
//		
//		Client client = clientService.findByEmail(email);
//		
		Panier panier = (Panier) request.getAttribute("panier", request.SCOPE_SESSION);
//		Panier panier = panierService.findByClient(client);
		
		if (panier == null) {
			panier = new Panier();
		}
		//panier.setClient(client);
		LignePanier lignePanier = panier.getLignesPanier().stream().filter(elt -> elt.getArticle().getId() == id)
				.findFirst().orElse(null);
		if (lignePanier == null) {
			lignePanier = new LignePanier();
			lignePanier.setArticle(articleRepository.findById(id).orElse(null));
			lignePanier.setQte(1);
			
			panier.addLignePanier(lignePanier);
			
			
		} else {
			lignePanier.setQte(lignePanier.getQte() + 1);
		}
		
		
		//panierService.save(panier);
		request.setAttribute("panier", panier, request.SCOPE_SESSION);
		return "redirect:/showPanier";
	}

	@PostMapping(value = "/modifQuantity")
	public String modifQuantity(@RequestParam long id, @RequestParam int qte, Model model, WebRequest request) {
			
		
		// Get login user information
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// Get authenticated user name - in this case, it means email
		String email = auth.getName();
		
		Client client = clientService.findByEmail(email);
		Panier panier = panierService.findByClient(client);
		
		LignePanier lignePanier = panier.getLignesPanier().stream().filter(elt -> elt.getArticle().getId() == id)
				.findFirst().get();
		
		lignePanier.setQte(qte);
		if (lignePanier.getQte() == 0) {
			panier.getLignesPanier().removeIf(elt -> elt.getArticle().getId() == id);
		}
//		if (op.equals("+")) {
//			lignePanier.setQte(lignePanier.getQte() + 1);
//		} else {
//			lignePanier.setQte(lignePanier.getQte() - 1);
//			if (lignePanier.getQte() == 0) {
//				panier.getLignesPanier().removeIf(elt -> elt.getArticle().getId() == id);
//			}
//		}
		request.setAttribute("panier", panier, request.SCOPE_SESSION);
		
		panierService.save(panier);
		return "redirect:/showPanier";
	}
	
	@GetMapping(value = "/deleteArticle")
	public String deleteArticle(@RequestParam long id, Model model, WebRequest request) {
		// Get login user information
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// Get authenticated user name - in this case, it means email
		String email = auth.getName();
				
		Client client = clientService.findByEmail(email);
		Panier panier = panierService.findByClient(client);
				
		LignePanier lignePanier = panier.getLignesPanier().stream().filter(elt -> elt.getArticle().getId() == id)
				.findFirst().get();
		lignePanier.setQte(0);
		if (lignePanier.getQte() == 0) {
			panier.getLignesPanier().removeIf(elt -> elt.getArticle().getId() == id);
		}
		panierService.save(panier);
		return "redirect:/showPanier";
	}
	
	@GetMapping(value = "/validationCart")
	public String validationCart(Model model, WebRequest request) {
		return "validationCart";
	}
//	@PostMapping(value = "/savePanier")
//	public String savePanier(Model model, WebRequest request) {
//		Panier panier = (Panier) request.getAttribute("panier", request.SCOPE_SESSION);		
//		
//		// Get login user information
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		// Get authenticated user name - in this case, it means email
//		String email = auth.getName();
//		// Get Client instance by email
//		Client client = clientService.findByEmail(email);
//		
//		panier.setClient(client);
//		
//		
//		// Save panier instance
//		panierService.save(panier);
//		
//		return "redirect:/showArticles";
//	}

	/*effacer un article panier*/
//	@GetMapping(value = "/deleteArticle")
//	public String deleteArticle(@RequestParam long id, Model model, WebRequest request) {
//		Article article = (Article) request.getAttribute("article", request.SCOPE_SESSION);
//		LignePanier ligne = new LignePanier();
//		ligne.setArticle(articleRepository.findById(id).orElse(null));
//		ligne.setQte(1);
//		Panier panier = (Panier) request.getAttribute("panier", request.SCOPE_SESSION);
//		panier.deleteLignePanier(ligne);
//		request.setAttribute("panier", panier, request.SCOPE_SESSION);
//		return "redirect:/showPanier";
//	}

}
