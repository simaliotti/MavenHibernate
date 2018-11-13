package com.humanbooster.hibernate.dao;

import java.util.List;

import org.hibernate.Session;


import com.humanbooster.hibernate.business.Categorie;


public interface CategorieDao {

	public void createCategorie(Categorie categorie);
	
	public List<Categorie> findAll();
	
	public Categorie findByName(String name);
	
	public Categorie findById(int id);
	
	public void update(Categorie categorie);
	
	public void delete(Categorie categorie);
	
	public Session openCurrentSession();
	
	public Session openCurrentSessionWithTransaction();
	
	public void closeCurrentSession();
	
	public void closeCurrentSessionWithTransaction();
	

	
	
	
	
	
}
