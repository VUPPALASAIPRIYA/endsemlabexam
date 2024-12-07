package com.vsp.endsem;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
	 public static void main(String[] args) {
	        // Load configuration and build session factory
	        Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();

	        // Perform update operation
	        Session session = factory.openSession();
	        Transaction transaction = session.beginTransaction();

	        // HQL Update Query
	        String hql = "UPDATE Department SET name = ?1, location = ?2 WHERE id = ?3";
	        int updatedEntities = session.createQuery(hql)
	                .setParameter(1, "Updated Name")
	                .setParameter(2, "Updated Location")
	                .setParameter(3, 1)
	                .executeUpdate();

	        System.out.println("Number of rows updated: " + updatedEntities);

	        // Commit and close
	        transaction.commit();
	        session.close();
	        factory.close();
	    }
	
	
	
}
