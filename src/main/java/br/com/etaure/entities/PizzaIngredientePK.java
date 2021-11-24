package br.com.etaure.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PizzaIngredientePK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "id_pizza")
	private Pizza pizza;
	
	@ManyToOne
	@JoinColumn(name = "id_ingrediente")
	private Ingrediente ingrediente;
	
	public PizzaIngredientePK() {
		
	}
	
	public PizzaIngredientePK(Pizza pizza, Ingrediente ingrediente) {
		this.pizza = pizza;
		this.ingrediente = ingrediente;
	}

	public Pizza getPizza() {
		return pizza;
	}
	
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public Ingrediente getIngrediente() {
		return ingrediente;
	}
	
	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ingrediente, pizza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaIngredientePK other = (PizzaIngredientePK) obj;
		return Objects.equals(ingrediente, other.ingrediente) && Objects.equals(pizza, other.pizza);
	}
	
}
