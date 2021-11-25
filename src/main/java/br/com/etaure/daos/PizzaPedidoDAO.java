package br.com.etaure.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.etaure.entities.Pedido;
import br.com.etaure.entities.Pizza;
import br.com.etaure.entities.PizzaPedido;
import br.com.etaure.entities.pks.PizzaPedidoPK;

public class PizzaPedidoDAO {

	private static EntityManager em;

	private static void createEntityManager() {
		if (em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Pizzaria Web");
			em = factory.createEntityManager();
		}
	}

	// Insere um novo PizzaPedido
	public static void insert(PizzaPedido pizzaPedido) {
		createEntityManager();

		em.getTransaction().begin();
		em.persist(pizzaPedido);
		em.getTransaction().commit();
	}

	public static List<PizzaPedido> findAll() {
		createEntityManager();

		String jpql = "SELECT pp FROM PizzaPedido pp";
		return em.createQuery(jpql, PizzaPedido.class).getResultList();
	}

	public static PizzaPedido findById(Pizza pizza, Pedido pedido) {
		createEntityManager();

		return em.find(PizzaPedido.class, new PizzaPedidoPK(pizza, pedido));
	}

	// Atualiza um PizzaPedido
	public static void updatePizzaPedido(PizzaPedido newPizzaPedido) {
		createEntityManager();

		PizzaPedido oldPizzaPedido = em.find(PizzaPedido.class, newPizzaPedido.getId());

		em.getTransaction().begin();

		oldPizzaPedido.setId(newPizzaPedido.getId());
		oldPizzaPedido.setQuantidade(newPizzaPedido.getQuantidade());
		oldPizzaPedido.setSubTotal(newPizzaPedido.getSubTotal());

		em.getTransaction().commit();
	}

	// Deleta um PizzaPedido
	public static void deletePizzaPedido(Pizza pizza, Pedido pedido) {
		createEntityManager();

		PizzaPedido pizzaPedido = em.find(PizzaPedido.class, new PizzaPedidoPK(pizza, pedido));

		em.getTransaction().begin();

		em.remove(pizzaPedido);

		em.getTransaction().commit();
	}

}
