package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


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
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
//	@Pattern(regexp = "^[A-Z][a-z]{1,19}$", message = "Le nom doit contenir entre 2 et 20 caractères alphabétiques, première lettre en majuscule")
	private String nom;
	@NonNull
//	@Pattern(regexp = "^[A-Z][a-z]{1,19}$", message = "Le prénom doit contenir entre 2 et 20 caractères alphabétiques, première lettre en majuscule")
	private String prenom;
	@NonNull
	private String email;
	@NonNull
	private String motDePasse;
	
	@Transient
	private String passeConfirmer;
	
	@ManyToMany
    @JoinTable(name = "client_role", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	

}
