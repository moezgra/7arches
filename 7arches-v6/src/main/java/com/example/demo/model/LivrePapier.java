package com.example.demo.model;

import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PROTECTED)
@Data
public class LivrePapier extends Livre {
	int nombrePages;
	int quantiteEnStock;

	public LivrePapier() {
		super();
	}

	public LivrePapier(String titre, Double prixHt, Double tauxTva, String numIsbn, String imageCouvertureUrl,
			String format, String resume, int nombrePages, int quantiteEnStock) {
		super(titre, prixHt, tauxTva, numIsbn, imageCouvertureUrl, format, resume);
		this.nombrePages = nombrePages;
		this.quantiteEnStock = quantiteEnStock;
	}

	public LivrePapier(long id, String titre, Double prixHt, Double tauxTva, String numIsbn, String imageCouvertureUrl,
			String format, String resume, int nombrePages, int quantiteEnStock) {
		super(id, titre, prixHt, tauxTva, numIsbn, imageCouvertureUrl, format, resume);
		this.nombrePages = nombrePages;
		this.quantiteEnStock = quantiteEnStock;
	}

}
