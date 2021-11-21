package br.com.etaure.application;

import br.com.etaure.daos.PizzaDAO;
import br.com.etaure.entities.Pizza;
import br.com.etaure.entities.enums.TamanhoDaPizza;

public class Program {

	private static PizzaDAO pizzaDAO = new PizzaDAO();
	
	public static void main(String[] args) {
		
		// Métodos para Pizza CRUD
//		Pizza pizza = new Pizza(null, "Americana", TamanhoDaPizza.GRANDE, 20.00);
//		pizzaDAO.insert(pizza);
		
		Pizza pizza = pizzaDAO.findById(3);
		System.out.println(pizza);
		
	}

}
