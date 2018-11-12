package com.humanbooster.hibernate.service.impl;

import java.util.Iterator;
import java.util.List;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.business.Categorie;
import com.humanbooster.hibernate.dao.ArticleDao;
import com.humanbooster.hibernate.dao.impl.ArticleDaoImpl;
import com.humanbooster.hibernate.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao = new ArticleDaoImpl();

	/**
	 * List all articles
	 */
	public List<Article> recupereArticles() {
		articleDao.openCurrentSession();
		List<Article> articles = articleDao.findAll();
		System.out.println("Nombre d'articles en base: " + articles.size());
		articleDao.closeCurrentSession();
		return articles;
	}

	/**
	 * Create article
	 */
	public Integer creerArticle(Article article) {
		Article art = article;

		articleDao.openCurrentSessionWithTransaction();
		Integer artId = articleDao.createArticle(art);

		// close session and commit the transaction
		articleDao.closeCurrentSessionWithTransaction();
		return artId;

	}

	/**
	 * Search for Article by Designation
	 * 
	 * @param designation
	 * @return article
	 */
	public Article chercherArticleParDesignation(String designation) {
		articleDao.openCurrentSession();
		Article article = articleDao.findByDesignation(designation);
		articleDao.closeCurrentSession();
		return article;
	}

	/**
	 * Search for Article by ID
	 * 
	 * @param idArticle
	 * @return article
	 */
	public Article chercherArticleParId(int idArticle) {
		articleDao.openCurrentSession();
		Article article = articleDao.findById(idArticle);
		articleDao.closeCurrentSession();
		return article;
	}

	/**
	 * Update Article
	 * 
	 * @article
	 * @return nb of updates entites
	 */
	public void updateArticle(Article article) {
		articleDao.openCurrentSessionWithTransaction();
		articleDao.updateArticle(article);
		articleDao.closeCurrentSessionWithTransaction();

	}

	/**
	 * Delete an Article
	 */
	public void deleteArticle(Article article) {
		articleDao.openCurrentSessionWithTransaction();
		articleDao.deleteArticle(article);
		articleDao.closeCurrentSessionWithTransaction();
	}


	/**
	 * Delete all Article
	 */
	public void deleteAll() {
		articleDao.openCurrentSessionWithTransaction();
		List<Article> listArticles = articleDao.findAll();
		for (Article article : listArticles) {
			articleDao.deleteArticle(article);
		}
		articleDao.closeCurrentSessionWithTransaction();
	}

	/**
	 * Search by Designation i.e approx research
	 */
	public Article searchByDesignation(String designation) {
		articleDao.openCurrentSessionWithTransaction();
		Article article = articleDao.searchByDesignation(designation);
		articleDao.closeCurrentSessionWithTransaction();
		
		return article;
	}
	
}
