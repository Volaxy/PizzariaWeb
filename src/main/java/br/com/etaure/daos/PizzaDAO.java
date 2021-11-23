package br.com.etaure.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.etaure.entities.Pizza;

public class PizzaDAO {

	private static EntityManager em;

	private void createEntityManager() {
		if (em == null) {
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

	public List<Pizza> findAll() {
		createEntityManager();

		String jpql = "SELECT p FROM Pizza p";
		return em.createQuery(jpql, Pizza.class).getResultList();
	}

	public Pizza findById(Integer id) {
		createEntityManager();

		return em.find(Pizza.class, id);
	}

	// Atualiza a Pizza
	public void updatePizza(Integer id, Pizza newPizza) {
		createEntityManager();

		Pizza oldPizza = em.find(Pizza.class, id);

		em.getTransaction().begin();

		oldPizza.setDescricao(newPizza.getDescricao());
		oldPizza.setTamanho(newPizza.getTamanho());
		oldPizza.setPreco(newPizza.getPreco());

		em.getTransaction().commit();
		em.close();
	}

	// Deleta a Pizza
	public void deletePizza(Integer id) {
		createEntityManager();
		
		Pizza pizza = em.find(Pizza.class, id);

		em.getTransaction().begin();
		
		em.remove(pizza);
		
		em.getTransaction().commit();
		
		em.close();
	}

}
