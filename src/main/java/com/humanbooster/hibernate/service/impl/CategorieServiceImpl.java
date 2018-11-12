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
}
