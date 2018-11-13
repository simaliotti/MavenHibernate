package com.humanbooster.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.humanbooster.hibernate.business.Categorie;

import com.humanbooster.hibernate.dao.CategorieDao;

@SuppressWarnings("unchecked")
public class CategorieDaoImpl implements CategorieDao {

	private Session session;
	private Transaction transaction;

	public void createCategorie(Categorie categorie) {
		session.save(categorie);
	}

	public List<Categorie> findAll() {
		return session.createQuery("from Categorie").getResultList();

	}

	public Categorie findByName(String name) {
		return (Categorie) session.createQuery("from Categorie where nom = :name").setParameter("name", name)
				.getSingleResult();
	}

	public Categorie findById(int id) {
		return (Categorie) session.createQuery("from Categorie where idCategorie = :id").setParameter("id", id)
				.getSingleResult();
	}

	public void update(Categorie categorie) {
		session.update(categorie);
	}

	public void delete(Categorie categorie) {
		session.delete(categorie);
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
}
