package br.com.etaure.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etaure.daos.PedidoDAO;
import br.com.etaure.daos.PizzaDAO;
import br.com.etaure.entities.Pedido;
import br.com.etaure.entities.Pizza;
import br.com.etaure.entities.dto.PedidoComNomeClienteDTO;
import br.com.etaure.entities.enums.TamanhoPizza;
import br.com.etaure.entities.enums.TipoPedido;

/**
 * Servlet implementation class MainController
 */
@WebServlet(urlPatterns = { "/MainController", "/main", "/addPizza", "/updatePizza", "/updateOldPizza",
		"/deletePizza", "/filtrarPresencial", "/filtrarEntrega"})
public class MainController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private PizzaDAO pizzaDAO = new PizzaDAO();

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
		case "/updatePizza":
			updatePizza(request, response);
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
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

	private void listPedidos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Pizza> pizzas = pizzaDAO.findAll();

		// Define uma variável contendo a lista de pizzas e direciona essa variável ao
		// documento "pizzas.jsp"
		request.setAttribute("pizzas", pizzas);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		List<PedidoComNomeClienteDTO> pedidos = new ArrayList<PedidoComNomeClienteDTO>();
		
		pedidoDAO.findAll().forEach(p -> {
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
		pizzaDAO.insert(pizza);

		response.sendRedirect("main");
	}

	private void updatePizza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer idSelectedPizza = Integer.valueOf(request.getParameter("id"));

		Pizza pizza = pizzaDAO.findById(idSelectedPizza);
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

		pizzaDAO.updatePizza(pizza.getId(), pizza);

		response.sendRedirect("main");
	}

	private void deletePizza(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		pizzaDAO.deletePizza(id);
		
		response.sendRedirect("main");
	}
	
	private void filtrarEntrega(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PedidoComNomeClienteDTO> pedidosComNome = getPedidosFiltrados(TipoPedido.ENTREGA);
		
		redirecionarPedidos(request, response, pedidosComNome);
	}

	

	private void filtrarPresencial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PedidoComNomeClienteDTO> pedidosComNome = getPedidosFiltrados(TipoPedido.PRESENCIAL);
		
		redirecionarPedidos(request, response, pedidosComNome);
	}
	
		private List<PedidoComNomeClienteDTO> getPedidosFiltrados(TipoPedido tipoPedido) {
			List<PedidoComNomeClienteDTO> pedidosComNome = new ArrayList<PedidoComNomeClienteDTO>();
			
			PedidoDAO pedidoDAO = new PedidoDAO();
			List<Pedido> pedidos = pedidoDAO.findAll();
			for (Pedido pedido : pedidos) {
				if(pedido.getTipoPedido() == tipoPedido) {
					pedidosComNome.add(new PedidoComNomeClienteDTO(pedido));
				}
			}
			
			return pedidosComNome;
		}
		
		private void redirecionarPedidos(HttpServletRequest request, HttpServletResponse response, List<PedidoComNomeClienteDTO> pedidosComNome) throws ServletException, IOException {
			List<Pizza> pizzas = pizzaDAO.findAll();
			
			request.setAttribute("pedidos", pedidosComNome);
			request.setAttribute("pizzas", pizzas);

			RequestDispatcher rd = request.getRequestDispatcher("pizzas.jsp");
			rd.forward(request, response);
		}

}
