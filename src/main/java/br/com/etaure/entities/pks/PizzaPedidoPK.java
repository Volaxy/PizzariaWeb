package br.com.etaure.entities.pks;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.etaure.entities.Pedido;
import br.com.etaure.entities.Pizza;

@Embeddable
public class PizzaPedidoPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "id_pizza")
	private Pizza pizza;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;
	
	public PizzaPedidoPK() {
		
	}

	public PizzaPedidoPK(Pizza pizza, Pedido pedido) {
		this.pizza = pizza;
		this.pedido = pedido;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pedido, pizza);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PizzaPedidoPK other = (PizzaPedidoPK) obj;
		return Objects.equals(pedido, other.pedido) && Objects.equals(pizza, other.pizza);
	}
	
}
