package br.com.etaure.application;

import br.com.etaure.daos.PizzaDAO;

public class Program {

	private static PizzaDAO pizzaDAO = new PizzaDAO();
	
	public static void main(String[] args) {
		
		// Métodos para Pizza CRUD
//		Pizza pizza = new Pizza(null, "Americana", TamanhoDaPizza.GRANDE, 20.00);
//		pizzaDAO.insert(pizza);
		
//		List<Pizza> pizzas = pizzaDAO.findAll();
//		for (Pizza pizza : pizzas) {
//			System.out.println(pizza);
//		}
		
//		Pizza pizza = pizzaDAO.findById(2);
//		System.out.println(pizza);
		
//		Pizza pizza = new Pizza(null, "Mista", TamanhoDaPizza.MEDIA, 90.00);
//		pizzaDAO.updatePizza(1, pizza);
		
		pizzaDAO.deletePizza(1);
		
	}

}
