package com.humanbooster.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.humanbooster.hibernate.business.Article;
import com.humanbooster.hibernate.business.Categorie;
import com.humanbooster.hibernate.dao.ArticleDao;

@SuppressWarnings("unchecked")
public class ArticleDaoImpl implements ArticleDao {

	private Session session;
	private Transaction transaction;

	public List<Article> findAll() {
		return session.createQuery("from Article").getResultList();
	}

	public Session openCurrentSession() {
		session = getSessionFactory().openSession();
		return session;

	}

	public Session openCurrentSessionWithTransaction() {
		session = getSessionFactory().openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public void closeCurrentSession() {
		session.close();
	}

	public void closeCurrentSessionWithTransaction() {
		transaction.commit();
		session.close();

	}

	private SessionFactory getSessionFactory() {

		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml")
				.build();
		Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

		return sessionFactory;

	}

	/**
	 * Create article
	 */
	@Override
	public Integer createArticle(Article article) {

		Integer artId = (Integer) session.save(article);
		// pour tester
		System.out.println("l'id de lobjet créé est : " + artId);
		return artId;

	}

	public Article findByDesignation(String designation) {

		return (Article) session.createQuery("from Article where designation=:articleDesignation")
				.setParameter("articleDesignation", designation).getSingleResult();
	}

	public Article findById(int idArticle) {
		return session.byId(Article.class).load(idArticle);
	}

	/**
	 * Different ways to update data
	 */
	@Override
	public void updateArticle(Article article) {
		/*
		 * String hql =
		 * "update Article set designation=:articleDesignation, nbPoints=:articlenbPoints, stock=:articleStock  where idArticle =:id"
		 * ; Query<Article> query = session.createQuery(hql);
		 * query.setParameter("articleDesignation", article.getDesignation());
		 * query.setParameter("articlenbPoints", article.getNbPoints());
		 * query.setParameter("articleStock", article.getStock());
		 * query.setParameter("id", article.getIdArticle()); query.executeUpdate();
		 */
		// session.update(article);
		// session.merge(article);

		session.createQuery(
				"update Article set designation=:articleDesignation, nbPoints=:articlenbPoints, stock=:articleStock  where idArticle =:id")
				.setParameter("articleDesignation", article.getDesignation())
				.setParameter("articlenbPoints", article.getNbPoints()).setParameter("articleStock", article.getStock())
				.setParameter("id", article.getIdArticle()).executeUpdate();

		// on peut aussi faire une update en récupértant un objet et le modifiant puis
		// commit (setAttribute avec les getter and setter)
	}

	/**
	 * Delete an article
	 */
	public void deleteArticle(Article article) {
		session.delete(article);
	}

	/**
	 * Research article using keyword
	 */
	public Article searchByDesignation(String designation) {
		return (Article) session.createQuery("from Article where designation like :articleDesignation")
				.setParameter("articleDesignation", "%" + designation + "%").getSingleResult();

	}
	
	public List<Article>findAllOrderedByName() {
		return session.createQuery("from Article order by designation").getResultList();
	}

}
