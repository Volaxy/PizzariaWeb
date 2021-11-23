package br.com.etaure.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainController
 */
@WebServlet(urlPatterns = {"/MainController", "/main", "insertPizza"})
public class MainController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
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
			case "/insertPizza":
				addPizza(request, response);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
		}
	}

	private void listPedidos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("pizzas.jsp");
	}
	
	private void addPizza(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("descricao"));
		System.out.println(request.getParameter("tamanho"));
		System.out.println(request.getParameter("preco"));
	}

}
