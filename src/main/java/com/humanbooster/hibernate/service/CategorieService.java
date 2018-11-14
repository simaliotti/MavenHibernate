package com.humanbooster.hibernate.service;

import java.util.List;

import com.humanbooster.hibernate.business.Categorie;

public interface CategorieService {

	public void createCategorie(Categorie categorie);

	public List<Categorie> findAll();

	public Categorie findByName(String name);

	public Categorie findById(int id);

	public void update(Categorie categorie);

	public void delete(Categorie categorie);

	public void deleteAll();
	
	public void deleteAll2();

}
