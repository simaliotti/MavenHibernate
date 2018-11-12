package com.humanbooster.hibernate.service;

import java.util.List;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.business.Categorie;

public interface ArticleService {

	public List<Article> recupereArticles();

	public Integer creerArticle(Article article);

	public Article chercherArticleParDesignation(String designation);

	public Article chercherArticleParId(int idArticle);
	
	public void updateArticle(Article article);
	
	public void deleteArticle(Article article);
	
	public void deleteAll();
	
	public Article searchByDesignation(String designation);
	
	public List<Article>findAllOrderedByName();
	
	
}
