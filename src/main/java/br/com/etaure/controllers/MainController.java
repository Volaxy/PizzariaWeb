package br.com.etaure.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.etaure.daos.PizzaDAO;
import br.com.etaure.entities.Pizza;
import br.com.etaure.entities.enums.TamanhoDaPizza;

/**
 * Servlet implementation class MainController
 */
@WebServlet(urlPatterns = {"/MainController", "/main", "/addPizza", "/updatePizza"})
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

	private void listPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pizza> pizzas = pizzaDAO.findAll();
		
		// Define uma variável contendo a lista de pizzas e direciona essa variável ao documento "pizzas.jsp"
		request.setAttribute("pizzas", pizzas);
		
		RequestDispatcher rd = request.getRequestDispatcher("pizzas.jsp");
		rd.forward(request, response);
	}
	
	private void addPizza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pizza pizza = new Pizza(null,
				request.getParameter("descricao"),
				TamanhoDaPizza.toEnum(Integer.valueOf(request.getParameter("tamanho"))),
				Double.valueOf(request.getParameter("preco")));
		System.out.println(pizza);
		pizzaDAO.insert(pizza);
	}
	
	private void updatePizza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idSelectedPizza = Integer.valueOf(request.getParameter("id"));
		
		Pizza pizza = pizzaDAO.findById(idSelectedPizza);
		request.setAttribute("id", pizza.getId());
		request.setAttribute("name", pizza.getDescricao());
		request.setAttribute("size", pizza.getTamanho().getCode());
		request.setAttribute("price", pizza.getPreco());
		
		RequestDispatcher rd = request.getRequestDispatcher("updatePizza.jsp");
		rd.forward(request, response);
	}

}
