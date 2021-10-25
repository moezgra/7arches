package com.example.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.dao.RoleRepository;
import com.example.demo.model.LivrePapier;
import com.example.demo.model.Role;

@SpringBootApplication
public class SetMArcheApplication implements ApplicationRunner {
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(SetMArcheApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		  LivrePapier livre1 = new LivrePapier("300 anecdotes de tournages", 35.50,
		  0.2, "978-2253160434", "300 anecdotes de tournages.jpg", "Poche",
		  "Caprices de stars, bourre-pifs, moments de grâce et grosses boulettes...\n"
		  + "les coulisses de vos fi lms cultes, comme si vous y étiez !", 189, 23);
		  LivrePapier livre5 = new LivrePapier("Peter Pan", 5.50, 0.2,
		  "572-8095383645", "Peter Pan.jpg", "Broché",
		  "Plongez dans la magie Disney à travers l’histoire de Peter Pan et ses plus belles scènes. Un bel album grand format de 96 pages richement illustré.."
		  , 273, 45); 
		  LivrePapier livre3 = new LivrePapier("Larousse du cinema", 28.0,
		  0.2, "979-1095383420", "Larousse du cinema.jpg", "Broché",
		  "Le Larousse du cinéma propose 125 rétrospectives essentielles <br> consacrées aux différentes facettes de l'histoire du cinéma."
		  , 107, 141); 
		  LivrePapier livre4 = new LivrePapier("Le livre de la jungle",
		  8.00, 0.2, "572-8095383735", "Le livre de la jungle.jpg", "Broché",
		  "Notes, présentation et dossier par Catherine Moreau", 273, 45);
		  LivrePapier livre2 = new LivrePapier("Harry Potter et l'Enfant Maudit",
				  21.00, 0.2, "572-8455383251", "Harry-Potter-et-l-Enfant-Maudit.jpg", "Broché",
				  "Quand passé et présents'entremêlent dangereusement, <br> père et fils se retrouvent face à une dure vérité <br> lesténèbres surviennent parfois des endroits les plus... ", 352, 45);
		  LivrePapier livre6 = new LivrePapier("Le texte du film Tome 2 : Les Crimes de Grindelwald ",
				  25.00, 0.2, "194-6825388284", "Les-Crimes-de-Grindelwald.jpg", "Poche",
				  "Suivez Norbert Dragonneau à Paris,dans le second volet des AnimauxFantastiques. Au cinéma le 14/11/2018.", 320, 35);
		  
		  LivrePapier livre7= new LivrePapier("Il était une fois... James Bond", 19.0,
				  0.2, "579-1035383150", "James-Bond.jpg", "Broché",
				  "Et si James Bond avait réellement existé ? Pour la première fois, Guillaume Évin, journaliste et spécialiste de l'agent 007, nous offre une biographie complète de cet héros."
				  , 107, 141); 
		  LivrePapier livre8= new LivrePapier("LES ARISTOCHATS - Disney Cinéma - L'histoire du film", 10.0,
				  0.2, "229-1125383580", "LES-ARISTOCHATS.jpg", "Broché",
				  "Retrouvez dans cet album grand format toute l'émotion du célèbre long-métrage des studios Disney.", 107, 141); 
		  
		  articleRepository.saveAll(Arrays.asList(livre1, livre2, livre3, livre7, livre5, livre6, livre4, livre8));
		  
		 
		  
		  Role role = new Role();
		  role.setName("admin");
		  
		  
		  roleRepository.save(role);
		 
	}
}
