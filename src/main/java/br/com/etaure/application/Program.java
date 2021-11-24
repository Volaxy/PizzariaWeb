package br.com.etaure.application;

import java.util.List;

import br.com.etaure.daos.ClienteDAO;
import br.com.etaure.daos.EnderecoDAO;
import br.com.etaure.daos.IngredienteDAO;
import br.com.etaure.entities.Cliente;
import br.com.etaure.entities.Ingrediente;

public class Program {

//	private static PizzaDAO pizzaDAO = new PizzaDAO();
//	private static EnderecoDAO enderecoDAO = new EnderecoDAO();
//	private static ClienteDAO clienteDAO = new ClienteDAO();
	private static IngredienteDAO ingredienteDAO = new IngredienteDAO();
	
	public static void main(String[] args) {
		
		// Métodos para Pizza CRUD
//		Pizza pizza = new Pizza(null, "Americana", TamanhoDaPizza.GRANDE, 20.00);
//		pizzaDAO.insert(pizza);
		
//		List<Pizza> pizzas = pizzaDAO.findAll();
//		for (Pizza pizza : pizzas) {
//			System.out.println(pizza);
//		}
		
//		System.out.println(pizzaDAO.findById(2));
		
//		Pizza pizza = new Pizza(null, "Mista", TamanhoDaPizza.MEDIA, 90.00);
//		pizzaDAO.updatePizza(1, pizza);
		
//		pizzaDAO.deletePizza(1);
		
		// ************************** //
		// Métodos para Endereço CRUD
//		Endereco endereco = new Endereco(null, "Viana", "Bairro de Viana", "Rua de Viana", 89, "Perto de Viana");
//		enderecoDAO.insert(endereco);
		
//		List<Endereco> enderecos = enderecoDAO.findAll();
//		for (Endereco endereco : enderecos) {
//			System.out.println(endereco);
//		}
//		
//		System.out.println(enderecoDAO.findById(4));
		
//		Endereco endereco = new Endereco(null, "Viana", "Bairro de Viana", "Rua de Viana", 89, "Perto de Viana");
//		enderecoDAO.updateEndereco(3, endereco);
//		
//		enderecoDAO.deleteEndereco(4);
		
		// ************************** //
		// Métodos para Cliente CRUD
//		Cliente cliente = new Cliente(null, "oi", "76234832", enderecoDAO.findById(2));
//		clienteDAO.insert(cliente);
//		
//		List<Cliente> clientes = clienteDAO.findAll();
//		for (Cliente cliente : clientes) {
//			System.out.println(cliente);
//		}
	
//		System.out.println(clienteDAO.findById(3));
		
//		Cliente cliente = new Cliente(null, "oi", "76234832", enderecoDAO.findById(2));
//		clienteDAO.updateCliente(3, cliente);
		
//		clienteDAO.deleteCliente(4);
		
		// ************************** //
		// Métodos para Ingrediente CRUD
//		Ingrediente ingrediente = new Ingrediente(null, "Cebola");
//		ingredienteDAO.insert(ingrediente);
		
//		List<Ingrediente> ingredientes = ingredienteDAO.findAll();
//		for (Ingrediente ingrediente : ingredientes) {
//			System.out.println(ingrediente);
//		}
		
//		System.out.println(ingredienteDAO.findById(4));
		
//		Ingrediente ingrediente = new Ingrediente(null, "Camarão");
//		ingredienteDAO.updateIngrediente(9, ingrediente);

//		ingredienteDAO.deleteIngrediente(5);
		
	}

}
