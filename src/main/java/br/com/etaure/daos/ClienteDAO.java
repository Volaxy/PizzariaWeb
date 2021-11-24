package br.com.etaure.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.etaure.entities.Cliente;

public class ClienteDAO {

	private static EntityManager em;

	private void createEntityManager() {
		if (em == null) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("Pizzaria Web");
			em = factory.createEntityManager();
		}
	}

	// Insere um novo Cliente
	public void insert(Cliente cliente) {
		createEntityManager();

		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}

	public List<Cliente> findAll() {
		createEntityManager();

		String jpql = "SELECT c FROM Cliente c";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}

	public Cliente findById(Integer id) {
		createEntityManager();

		return em.find(Cliente.class, id);
	}

	// Atualiza um Cliente
	public void updateCliente(Integer id, Cliente newCliente) {
		createEntityManager();

		Cliente oldCliente = em.find(Cliente.class, id);

		em.getTransaction().begin();

		oldCliente.setNome(newCliente.getNome());
		oldCliente.setCpf(newCliente.getCpf());
		oldCliente.setEndereco(newCliente.getEndereco());

		em.getTransaction().commit();
	}

	// Deleta um Cliente
	public void deleteCliente(Integer id) {
		createEntityManager();

		Cliente cliente = em.find(Cliente.class, id);

		em.getTransaction().begin();

		em.remove(cliente);

		em.getTransaction().commit();
	}

}
