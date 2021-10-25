package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private Long numero;
	@NonNull
	private Date date;
	
	public double CalculerprixTotalHt() {
		// TODO - implement Commande.CalculerprixTotalHt
		throw new UnsupportedOperationException();
	}

	public double CalculerPrixTotalTtc() {
		// TODO - implement Commande.CalculerPrixTotalTtc
		throw new UnsupportedOperationException();
	}

}
