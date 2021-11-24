package br.com.etaure.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.etaure.entities.Pedido;

public class PedidoDAO {

	private static EntityManager em;

	private void createEntityManager() {
		if (em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Pizzaria Web");
			em = factory.createEntityManager();
		}
	}

	// Insere um novo Pedido
	public void insert(Pedido pedido) {
		createEntityManager();

		em.getTransaction().begin();
		em.persist(pedido);
		em.getTransaction().commit();
	}

	public List<Pedido> findAll() {
		createEntityManager();

		String jpql = "SELECT p FROM Pedido p";
		return em.createQuery(jpql, Pedido.class).getResultList();
	}

	public Pedido findById(Integer id) {
		createEntityManager();

		return em.find(Pedido.class, id);
	}

	// Atualiza um Pedido
	public void updatePedido(Integer id, Pedido newPedido) {
		createEntityManager();

		Pedido oldPedido = em.find(Pedido.class, id);

		em.getTransaction().begin();

		oldPedido.setTipoPedido(newPedido.getTipoPedido());
		oldPedido.setTipoPagamento(newPedido.getTipoPagamento());
		oldPedido.setTotal(newPedido.getTotal());
		oldPedido.setCliente(newPedido.getCliente());

		em.getTransaction().commit();
	}

	// Deleta um Pedido
	public void deletePedido(Integer id) {
		createEntityManager();

		Pedido pedido = em.find(Pedido.class, id);

		em.getTransaction().begin();

		em.remove(pedido);

		em.getTransaction().commit();
	}

}
