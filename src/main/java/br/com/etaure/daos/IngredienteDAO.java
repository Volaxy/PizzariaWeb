package br.com.etaure.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.etaure.entities.Ingrediente;

public class IngredienteDAO {

	private static EntityManager em;

	private void createEntityManager() {
		if (em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Pizzaria Web");
			em = factory.createEntityManager();
		}
	}

	// Insere um novo Ingrediente
	public void insert(Ingrediente ingrediente) {
		createEntityManager();

		em.getTransaction().begin();
		em.persist(ingrediente);
		em.getTransaction().commit();
	}

	public List<Ingrediente> findAll() {
		createEntityManager();

		String jpql = "SELECT i FROM Ingrediente i";
		return em.createQuery(jpql, Ingrediente.class).getResultList();
	}

	public Ingrediente findById(Integer id) {
		createEntityManager();

		return em.find(Ingrediente.class, id);
	}

	// Atualiza um Ingrediente
	public void updateIngrediente(Integer id, Ingrediente newIngrediente) {
		createEntityManager();

		Ingrediente oldIngrediente = em.find(Ingrediente.class, id);

		em.getTransaction().begin();

		oldIngrediente.setDescricao(newIngrediente.getDescricao());

		em.getTransaction().commit();
	}

	// Deleta um Ingrediente
	public void deleteIngrediente(Integer id) {
		createEntityManager();

		Ingrediente ingrediente = em.find(Ingrediente.class, id);

		em.getTransaction().begin();

		em.remove(ingrediente);

		em.getTransaction().commit();
	}

}
