package br.com.etaure.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.etaure.entities.Ingrediente;
import br.com.etaure.entities.Pizza;
import br.com.etaure.entities.PizzaIngrediente;
import br.com.etaure.entities.pks.PizzaIngredientePK;

public class PizzaIngredienteDAO {

	private static EntityManager em;

	private void createEntityManager() {
		if (em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Pizzaria Web");
			em = factory.createEntityManager();
		}
	}

	// Insere um novo PizzaIngrediente
	public void insert(PizzaIngrediente pizzaIngrediente) {
		createEntityManager();

		em.getTransaction().begin();
		em.persist(pizzaIngrediente);
		em.getTransaction().commit();
	}

	public List<PizzaIngrediente> findAll() {
		createEntityManager();

		String jpql = "SELECT pi FROM PizzaIngrediente pi";
		return em.createQuery(jpql, PizzaIngrediente.class).getResultList();
	}

	public PizzaIngrediente findById(Pizza pizza, Ingrediente ingrediente) {
		createEntityManager();

		return em.find(PizzaIngrediente.class, new PizzaIngredientePK(pizza, ingrediente));
	}

	// Atualiza um PizzaIngrediente
	public void updatePizzaIngrediente(PizzaIngrediente newPizzaIngrediente) {
		createEntityManager();

		PizzaIngrediente oldPizzaIngrediente = em.find(PizzaIngrediente.class, newPizzaIngrediente.getId());

		em.getTransaction().begin();

		oldPizzaIngrediente.setId(newPizzaIngrediente.getId());
		oldPizzaIngrediente.setQuantidade(newPizzaIngrediente.getQuantidade());
		
		em.getTransaction().commit();
	}

	// Deleta um PizzaIngrediente
	public void deletePizzaIngrediente(Pizza pizza, Ingrediente ingrediente) {
		createEntityManager();

		PizzaIngrediente pizzaIngrediente = em.find(PizzaIngrediente.class, new PizzaIngredientePK(pizza, ingrediente));

		em.getTransaction().begin();

		em.remove(pizzaIngrediente);

		em.getTransaction().commit();
	}

}
