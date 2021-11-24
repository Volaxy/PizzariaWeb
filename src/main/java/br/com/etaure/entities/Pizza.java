package br.com.etaure.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.etaure.entities.enums.TamanhoPizza;

@Entity
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	
	@Enumerated(value = EnumType.STRING)
	private TamanhoPizza tamanho;
	private Double preco;
	
	@OneToMany(mappedBy = "id.pizza")
	private Set<PizzaIngrediente> pizzaIngredientes = new HashSet<PizzaIngrediente>();
	
	@OneToMany(mappedBy = "id.pizza")
	private Set<PizzaPedido> pizzaPedidos = new HashSet<PizzaPedido>();
	
	public Pizza() {
		
	}

	public Pizza(Integer id, String descricao, TamanhoPizza tamanho, Double preco) {
		this.id = id;
		this.descricao = descricao;
		this.tamanho = tamanho;
		this.preco = preco;
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

	public TamanhoPizza getTamanho() {
		return tamanho;
	}

	public void setTamanho(TamanhoPizza tamanho) {
		this.tamanho = tamanho;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Set<PizzaIngrediente> getPizzaIngredientes() {
		return pizzaIngredientes;
	}

	public void setPizzaIngredientes(Set<PizzaIngrediente> pizzaIngredientes) {
		this.pizzaIngredientes = pizzaIngredientes;
	}
	
		public List<Ingrediente> getIngredientes() {
			List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
			
			for (PizzaIngrediente pizzaIngrediente : pizzaIngredientes) {
				ingredientes.add(pizzaIngrediente.getIngrediente());
			}
			
			return ingredientes;
		}

	public Set<PizzaPedido> getPizzaPedidos() {
		return pizzaPedidos;
	}

	public void setPizzaPedidos(Set<PizzaPedido> pizzaPedidos) {
		this.pizzaPedidos = pizzaPedidos;
	}
	
		public List<Pedido> getPedidos() {
			List<Pedido> pedidos = new ArrayList<Pedido>();
			
			for (PizzaPedido pizzaPedido : pizzaPedidos) {
				pedidos.add(pizzaPedido.getPedido());
			}
			
			return pedidos;
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
		Pizza other = (Pizza) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", descricao=" + descricao + ", tamanho=" + tamanho + ", preco=" + preco
				+ "]";
	}

	
	
}
