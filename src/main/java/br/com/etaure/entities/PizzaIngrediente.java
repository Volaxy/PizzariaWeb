package br.com.etaure.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pizza_ingrediente")
public class PizzaIngrediente {

	@EmbeddedId
	private PizzaIngredientePK id = new PizzaIngredientePK();
	
	private Integer quantidade;
	
	public PizzaIngrediente() {
		
	}

	public PizzaIngrediente(Pizza pizza, Ingrediente ingrediente, Integer quantidade) {
		this.id.setPizza(pizza);
		this.id.setIngrediente(ingrediente);
		this.quantidade = quantidade;
	}

	public PizzaIngredientePK getId() {
		return id;
	}

	public void setId(PizzaIngredientePK id) {
		this.id = id;
	}
	
		public Pizza getPizza() {
			return id.getPizza();
		}
		
		public Ingrediente getIngrediente() {
			return id.getIngrediente();
		}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaIngrediente other = (PizzaIngrediente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PizzaIngrediente [id=" + id.getPizza() +
				"," + id.getIngrediente() +
				", quantidade=" + quantidade + "]";
	}
	
}
