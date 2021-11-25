package br.com.etaure.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.etaure.entities.pks.PizzaPedidoPK;

@Entity
@Table(name = "pizza_pedido")
public class PizzaPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PizzaPedidoPK id = new PizzaPedidoPK();
	
	private Integer quantidade;
	private Double subTotal;
	
	public PizzaPedido() {
		
	}

	public PizzaPedido(Pizza pizza, Pedido pedido, Integer quantidade, Double subTotal) {
		this.id.setPizza(pizza);
		this.id.setPedido(pedido);
		this.quantidade = quantidade;
		this.subTotal = subTotal;
	}

	public PizzaPedidoPK getId() {
		return id;
	}

	public void setId(PizzaPedidoPK id) {
		this.id.setPizza(id.getPizza());
		this.id.setPedido(id.getPedido());
	}
	
		public Pizza getPizza() {
			return id.getPizza();
		}
		
		public Pedido getPedido() {
			return id.getPedido();
		}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
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
		PizzaPedido other = (PizzaPedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "PizzaPedido [id=" + id.getPizza() + "," + id.getPedido() + ", quantidade=" + quantidade + ", subTotal=" + subTotal + "]";
	}
	
}
