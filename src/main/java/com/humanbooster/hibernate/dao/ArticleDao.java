package com.humanbooster.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.business.Categorie;

public interface ArticleDao {

	

	
	public List<Article> findAll();
	
	public Integer createArticle(Article article);
	
	public Article findByDesignation(String designation);

	public Article findById(int idArticle);
	
	public void updateArticle(Article Article);
	
	public void deleteArticle(Article article);
	
	public Session openCurrentSession();

	public Session openCurrentSessionWithTransaction();

	public void closeCurrentSession();

	public void closeCurrentSessionWithTransaction();
}
