package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
/**
 * 
 * @author Moêz Grami
 * Cette classe est une classe mère dont hérite la classe Livre. 
 * @param id Identifiant unique de l'Article
 * @param titre Titre de l'article
 * @param prixHt Prix hors taxe de l'article
 * @param tauxTva Tauw TVA 
 *
 */
@Entity
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String titre;
	Double prixHt;
	Double tauxTva;

	public Article() {
		super();
	}

	public Article(String titre, Double prixHt, Double tauxTva) {
		super();
		this.titre = titre;
		this.prixHt = prixHt;
		this.tauxTva = tauxTva;
	}

	public Article(Long id, String titre, Double prixHt, Double tauxTva) {
		super();
		this.id = id;
		this.titre = titre;
		this.prixHt = prixHt;
		this.tauxTva = tauxTva;
	}
	/** 
	 * Cette méthode permet de calculer le prix ttc.
	 * Le prix ttc est obtenu par la multiplication des 2 attributs
	 * qui sont prixHt et tauxTva
	 * @return Le prix Ttc.
	 */
	public double CalculerPrixTtc(Long prixHt, Long tauxTva) {
		return (prixHt * tauxTva);
	}

	
}
