package br.com.etaure.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ingrediente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	@OneToMany(mappedBy = "id.ingrediente")
	private Set<PizzaIngrediente> pizzaIngredientes = new HashSet<PizzaIngrediente>();
	
	public Ingrediente() {
		
	}

	public Ingrediente(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<PizzaIngrediente> getPizzaIngredientes() {
		return pizzaIngredientes;
	}

	public void setPizzaIngredientes(Set<PizzaIngrediente> pizzaIngredientes) {
		this.pizzaIngredientes = pizzaIngredientes;
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
		Ingrediente other = (Ingrediente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", descricao=" + descricao + "]";
	}
	
}
