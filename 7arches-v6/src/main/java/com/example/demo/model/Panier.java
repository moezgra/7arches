package com.example.demo.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/** 
 * @author Moêz Grami
 * Cette classe représente le panier et elle est associée au LignePanier.
 * Elle permet de vêrifier la validité des élements de panier.
 * 
 * @version 1.0
 * */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Panier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/** 
	 * ArrayList lignesPanier est un tableau dynamique qui implémente l'interface List. 
	 * L'utilisateur de cette interface a le contrôle total sur les éléments insérés 
	 * et y accède par position ainsi que la recherche des éléments dans la liste.
	 */
	@ElementCollection
	private List<LignePanier> lignesPanier = new LinkedList<>();
	
	@OneToOne
	private Client client;

	/** 
	 * La méthode addLignePanier permet d'ajouter les articles dans la liste LignesPanier
	 * 
	 * @param element : une ligne de panier qui sera ajouté à la liste lignesPanier
	 * @return true dans tous les cas
	 * */	
	public boolean addLignePanier(LignePanier element) {
		
		return lignesPanier.add(element);
	}
	
//	/** 
//	 * La méthode deleteLignePanier permet de supprimer les articles dans la liste LignesPanier
//	 * 
//	 * @param element : une ligne de panier qui sera supprimé de la liste lignesPanier
//	 * @return true dans tous les cas si l'élément à supprimer est présent
//	 * */	
//	public boolean deleteLignePanier(LignePanier e) {
//		return lignesPanier.remove(e);
//	}
//	
//	public boolean updateLignePanier(LignePanier e) {
//		return lignesPanier.add(e);
//	}
//	
//	/** 
//	 * La méthode prixTotalPanier permet de calculer le prix total des artciles du panier
//	 * Initialement,le prix par défaut est 0. 
//	 * Une fois qu'un article est ajouté au lignesPanier, la méthode article.montant() permettra d'ajouter 
//	 * son montant au prixTotal
//	 * @return prixTotal qui est le prix total de tous les articles ajoutés au panier.
//	 */
	public double prixTotalPanier() {
		double prixTotal = 0;
		for(LignePanier article : lignesPanier) {
			prixTotal = prixTotal + article.montant();
		}
		return prixTotal;
	}
	
}
