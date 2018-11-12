package com.humanbooster.hibernate.service;

import java.util.List;

import com.humanbooster.hibernate.business.Categorie;

public interface CategorieService {

	public void createCategorie(Categorie categorie);
	
	public List<Categorie> findAll();

}
