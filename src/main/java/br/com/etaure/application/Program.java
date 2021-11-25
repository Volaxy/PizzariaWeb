package br.com.etaure.application;

public class Program {

//	private static PizzaDAO pizzaDAO = new PizzaDAO();
//	private static EnderecoDAO enderecoDAO = new EnderecoDAO();
//	private static ClienteDAO clienteDAO = new ClienteDAO();
//	private static IngredienteDAO ingredienteDAO = new IngredienteDAO();
//	private static PizzaIngredienteDAO pizzaIngredienteDAO = new PizzaIngredienteDAO();
//	private static PedidoDAO pedidoDAO = new PedidoDAO();
//	private static PizzaPedidoDAO pizzaPedidoDAO = new PizzaPedidoDAO();
	
	public static void main(String[] args) {
		
		// Métodos para Pizza CRUD
//		Pizza pizza = new Pizza(null, "Americana", TamanhoPizza.GRANDE, 20.00);
//		pizzaDAO.insert(pizza);
		
//		List<Pizza> pizzas = pizzaDAO.findAll();
//		for (Pizza pizza : pizzas) {
//			System.out.println(pizza);
//		}
		
//		System.out.println(pizzaDAO.findById(2));
		
//		Pizza pizza = new Pizza(null, "Mista", TamanhoPizza.MEDIA, 90.00);
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
		
		
		// ************************** //
		// Métodos para PizzaIngrediente CRUD
//		PizzaIngrediente pi = new PizzaIngrediente(pizzaDAO.findById(6), ingredienteDAO.findById(4), 3);
//		pizzaIngredienteDAO.insert(pi);
		
//		List<PizzaIngrediente> pizzaIngredientes = pizzaIngredienteDAO.findAll();
//		for (PizzaIngrediente pizzaIngrediente : pizzaIngredientes) {
//			System.out.println(pizzaIngrediente);
//		}
		
//		PizzaIngrediente pizzaIngrediente = pizzaIngredienteDAO.findById(pizzaDAO.findById(2), ingredienteDAO.findById(6));
//		System.out.println(pizzaIngrediente);
		
//		PizzaIngrediente pi = new PizzaIngrediente(pizzaDAO.findById(6), ingredienteDAO.findById(4), 30);
//		pizzaIngredienteDAO.updatePizzaIngrediente(pi);
		
//		pizzaIngredienteDAO.deletePizzaIngrediente(pizzaDAO.findById(2), ingredienteDAO.findById(6));
		
		// ************************** //
		// Métodos para Pedido CRUD
//		Pedido pedido = new Pedido(null, TipoPedido.ENTREGA, TipoPagamento.CARTAO, 90.00, clienteDAO.findById(1));
//		pedidoDAO.insert(pedido);
		
//		List<Pedido> pedidos = pedidoDAO.findAll();
//		pedidos.forEach(System.out::println);
		
//		System.out.println(pedidoDAO.findById(14));
		
//		pedidoDAO.updatePedido(14, new Pedido(null, TipoPedido.ENTREGA, TipoPagamento.CARTAO, 90.00, clienteDAO.findById(1)));
		
//		pedidoDAO.deletePedido(14);
		
		// ************************** //
		// Métodos para Pedido CRUD
//		PizzaPedido pizzaPedido = new PizzaPedido(pizzaDAO.findById(4), pedidoDAO.findById(13), 2, 35.00);
//		pizzaPedidoDAO.insert(pizzaPedido);
		
//		List<PizzaPedido> pizzaPedidos = pizzaPedidoDAO.findAll();
//		pizzaPedidos.forEach(System.out::println);
		
//		System.out.println(pizzaPedidoDAO.findById(pizzaDAO.findById(4), pedidoDAO.findById(13)));
		
//		PizzaPedido pizzaPedido = new PizzaPedido(pizzaDAO.findById(4), pedidoDAO.findById(13), 20, 35.00);
//		pizzaPedidoDAO.updatePizzaPedido(pizzaPedido);
		
//		pizzaPedidoDAO.deletePizzaPedido(pizzaDAO.findById(4), pedidoDAO.findById(13));
		
	}

}
