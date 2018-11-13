package com.humanbooster.hibernate.service.impl;

import java.util.List;

import com.humanbooster.hibernate.business.Categorie;
import com.humanbooster.hibernate.dao.CategorieDao;
import com.humanbooster.hibernate.dao.impl.CategorieDaoImpl;
import com.humanbooster.hibernate.service.CategorieService;

public class CategorieServiceImpl implements CategorieService {

	private CategorieDao categorieDao = new CategorieDaoImpl();

	@Override
	public void createCategorie(Categorie categorie) {
		categorieDao.openCurrentSessionWithTransaction();
		categorieDao.createCategorie(categorie);
		categorieDao.closeCurrentSessionWithTransaction();

	}

	public List<Categorie> findAll() {
		categorieDao.openCurrentSession();
		List<Categorie> listCategorie = categorieDao.findAll();
		categorieDao.closeCurrentSession();
		return listCategorie;
	}

	public Categorie findByName(String name) {
		categorieDao.openCurrentSession();
		Categorie cat = categorieDao.findByName(name);
		categorieDao.closeCurrentSession();
		return cat;
	}

	public Categorie findById(int id) {
		categorieDao.openCurrentSession();
		Categorie cat = categorieDao.findById(id);
		categorieDao.closeCurrentSession();
		return cat;
	}

	public void update(Categorie categorie) {
		categorieDao.openCurrentSessionWithTransaction();
		categorieDao.update(categorie);
		categorieDao.closeCurrentSessionWithTransaction();
	}

	public void delete(Categorie categorie) {
		categorieDao.openCurrentSessionWithTransaction();
		categorieDao.delete(categorie);
		categorieDao.closeCurrentSessionWithTransaction();
	}

}
