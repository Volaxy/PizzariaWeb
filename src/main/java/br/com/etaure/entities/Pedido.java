package br.com.etaure.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.etaure.entities.enums.TipoPagamento;
import br.com.etaure.entities.enums.TipoPedido;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipo_pedido")
	private TipoPedido tipoPedido;
	
	@Enumerated(value = EnumType.STRING)
	@Column(name = "tipo_pagamento")
	private TipoPagamento tipoPagamento;
	private Double total;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	public Pedido() {
		
	}

	public Pedido(Integer id, TipoPedido tipoPedido, TipoPagamento tipoPagamento, Double total, Cliente cliente) {
		this.id = id;
		this.tipoPedido = tipoPedido;
		this.tipoPagamento = tipoPagamento;
		this.total = total;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPedido getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(TipoPedido tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", tipoPedido=" + tipoPedido + ", tipoPagamento=" + tipoPagamento + ", total="
				+ total + ", cliente=" + cliente + "]";
	}
	
}
