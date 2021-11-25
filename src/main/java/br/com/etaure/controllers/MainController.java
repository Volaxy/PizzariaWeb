package br.com.etaure.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import br.com.etaure.daos.ClienteDAO;
import br.com.etaure.daos.PedidoDAO;
import br.com.etaure.daos.PizzaDAO;
import br.com.etaure.entities.Pedido;
import br.com.etaure.entities.Pizza;
import br.com.etaure.entities.dto.PedidoComNomeClienteDTO;
import br.com.etaure.entities.enums.TamanhoPizza;
import br.com.etaure.entities.enums.TipoPagamento;
import br.com.etaure.entities.enums.TipoPedido;

/**
 * Servlet implementation class MainController
 */
@WebServlet(urlPatterns = { "/MainController", "/main", "/addPizza", "/updatePizzaPage", "/updateOldPizza",
		"/deletePizza", "/filtrarPresencial", "/filtrarEntrega", "/addPedido" })
public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	private static String queueName = "pedidos";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		System.out.println(action);
		switch (action) {
		case "/main":
			listPedidos(request, response);
			break;
		case "/addPizza":
			addPizza(request, response);
			break;
		case "/updatePizzaPage":
			updatePizzaPage(request, response);
			break;
		case "/updateOldPizza":
			updateOldPizza(request, response);
			break;
		case "/deletePizza":
			deletePizza(request, response);
			break;
		case "/filtrarPresencial":
			filtrarPresencial(request, response);
			break;
		case "/filtrarEntrega":
			filtrarEntrega(request, response);
			break;
		case "/addPedido":
			try {
				addPedido(request, response);
			} catch (ServletException | IOException | JMSException e) {
				e.printStackTrace();
			}
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

	private void listPedidos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Pizza> pizzas = PizzaDAO.findAll();

		// Define uma variável contendo a lista de pizzas e direciona essa variável ao
		// documento "pizzas.jsp"
		request.setAttribute("pizzas", pizzas);

		List<PedidoComNomeClienteDTO> pedidos = new ArrayList<PedidoComNomeClienteDTO>();

		PedidoDAO.findAll().forEach(p -> {
			pedidos.add(new PedidoComNomeClienteDTO(p));
		});

		request.setAttribute("pedidos", pedidos);

		RequestDispatcher rd = request.getRequestDispatcher("pizzas.jsp");
		rd.forward(request, response);
	}

	private void addPizza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pizza pizza = new Pizza(null, request.getParameter("descricao"),
				TamanhoPizza.toEnum(Integer.valueOf(request.getParameter("tamanho"))),
				Double.valueOf(request.getParameter("preco")));
		System.out.println(pizza);
		PizzaDAO.insert(pizza);

		response.sendRedirect("main");
	}

	private void updatePizzaPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idSelectedPizza = Integer.valueOf(request.getParameter("id"));

		Pizza pizza = PizzaDAO.findById(idSelectedPizza);
		request.setAttribute("id", pizza.getId());
		request.setAttribute("name", pizza.getDescricao());
		request.setAttribute("size", pizza.getTamanho().getCode());
		request.setAttribute("price", pizza.getPreco());

		RequestDispatcher rd = request.getRequestDispatcher("updatePizza.jsp");
		rd.forward(request, response);
	}

	private void updateOldPizza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pizza pizza = new Pizza(Integer.valueOf(request.getParameter("id")), request.getParameter("descricao"),
				TamanhoPizza.toEnum(Integer.valueOf(request.getParameter("tamanho"))),
				Double.valueOf(request.getParameter("preco")));

		PizzaDAO.updatePizza(pizza.getId(), pizza);

		response.sendRedirect("main");
	}

	private void deletePizza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));

		PizzaDAO.deletePizza(id);

		response.sendRedirect("main");
	}

	private void filtrarEntrega(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PedidoComNomeClienteDTO> pedidosComNome = getPedidosFiltrados(TipoPedido.ENTREGA);

		redirecionarPedidos(request, response, pedidosComNome);
	}

	private void filtrarPresencial(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<PedidoComNomeClienteDTO> pedidosComNome = getPedidosFiltrados(TipoPedido.PRESENCIAL);

		redirecionarPedidos(request, response, pedidosComNome);
	}

	private List<PedidoComNomeClienteDTO> getPedidosFiltrados(TipoPedido tipoPedido) {
		List<PedidoComNomeClienteDTO> pedidosComNome = new ArrayList<PedidoComNomeClienteDTO>();

		List<Pedido> pedidos = PedidoDAO.findAll();
		for (Pedido pedido : pedidos) {
			if (pedido.getTipoPedido() == tipoPedido) {
				pedidosComNome.add(new PedidoComNomeClienteDTO(pedido));
			}
		}

		return pedidosComNome;
	}

	private void redirecionarPedidos(HttpServletRequest request, HttpServletResponse response,
			List<PedidoComNomeClienteDTO> pedidosComNome) throws ServletException, IOException {
		List<Pizza> pizzas = PizzaDAO.findAll();

		request.setAttribute("pedidos", pedidosComNome);
		request.setAttribute("pizzas", pizzas);

		RequestDispatcher rd = request.getRequestDispatcher("pizzas.jsp");
		rd.forward(request, response);
	}

	private void addPedido(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, JMSException {
		Pedido pedido = new Pedido(null, TipoPedido.toEnum(Integer.valueOf(request.getParameter("entrega"))),
				TipoPagamento.toEnum(Integer.valueOf(request.getParameter("pagamento"))),
				Double.parseDouble(request.getParameter("preco")),
				ClienteDAO.findById(Integer.parseInt(request.getParameter("idCliente"))));

		PedidoDAO.insert(pedido);
		
		System.out.println("url = " + url);
		
		// ********* Serviço de Mensageria ********* //
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue(queueName);
		
		MessageProducer producer = session.createProducer(destination);
		
		// Cria uma mensagem editada e formatada contendo os dados do pedido;
		StringBuilder sb = new StringBuilder();
		
		sb.append("O pedido com o seguinte id: " + pedido.getId() + " foi registrado!");
		sb.append("\nTipo de Entrega: " + pedido.getTipoPedido());
		sb.append("\nTipo de Pagamento: " + pedido.getTipoPagamento());
		sb.append("\nTotal: R$" + pedido.getTotal());
		sb.append("\nDados do Cliente:");
		sb.append("\n\tNome: " + pedido.getCliente().getNome());
		sb.append("\n\tCpf: " + pedido.getCliente().getCpf());
		sb.append("\n\tEndereço do Cliente:");
		sb.append("\n\t\tCidade: " + pedido.getCliente().getEndereco().getCidade());
		sb.append("\n\t\tBairro: " + pedido.getCliente().getEndereco().getBairro());
		sb.append("\n\t\tRua: " + pedido.getCliente().getEndereco().getRua());
		sb.append("\n\t\tNúmero: " + pedido.getCliente().getEndereco().getNumero());
		sb.append("\n\t\tLogradouro: " + pedido.getCliente().getEndereco().getLogradouro());
				
		
		TextMessage message = session.createTextMessage(sb.toString());
		
		producer.send(message);
		
		System.out.println("Message '" + message.getText() + ", Sent Successfully to the Queue");
		connection.close();
		// ***************************************** //
		
		response.sendRedirect("main");
	}

}
