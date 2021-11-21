package br.com.etaure.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.etaure.entities.Pizza;

public class PizzaDAO {

	private static EntityManager em;
	
	private void createEntityManager() {
		if(em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Pizzaria Web");
			em = factory.createEntityManager();
		}
	}
	
	// Insere uma nova Pizza
	public void insert(Pizza pizza) {
		createEntityManager();
		
		em.getTransaction().begin();
		em.persist(pizza);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public Pizza findById(Integer id) {
		createEntityManager();
		
		return em.find(Pizza.class, id);
	}
	
}
