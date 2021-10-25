package com.example.demo.model;

import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class Livre extends Article {

	String numIsbn;
	String imageCouvertureUrl;
	String format;
	String resume;

	public Livre() {
		super();
	}
	
	public Livre(String titre, Double prixHt, Double tauxTva, String numIsbn, String imageCouvertureUrl, String format,
			String resume) {
		super(titre, prixHt, tauxTva);
		this.numIsbn = numIsbn;
		this.imageCouvertureUrl = imageCouvertureUrl;
		this.format = format;
		this.resume = resume;
	}

	public Livre(Long id, String titre, Double prixHt, Double tauxTva, String numIsbn, String imageCouvertureUrl,
			String format, String resume) {
		super(id, titre, prixHt, tauxTva);
		this.numIsbn = numIsbn;
		this.imageCouvertureUrl = imageCouvertureUrl;
		this.format = format;
		this.resume = resume;
	}



}
