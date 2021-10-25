package com.example.demo.model;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LignePanier {

	private int qte;
	
	@OneToOne
	private Article article;
		
	
	public double montant() {
		double montant = this.qte * this.article.getPrixHt();
		return montant;
	}
	
	
	
}
