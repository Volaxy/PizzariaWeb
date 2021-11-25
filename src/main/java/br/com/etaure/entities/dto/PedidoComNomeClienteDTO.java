package br.com.etaure.entities.dto;

import br.com.etaure.entities.Pedido;
import br.com.etaure.entities.enums.TipoPagamento;
import br.com.etaure.entities.enums.TipoPedido;

public class PedidoComNomeClienteDTO {

	private Integer id;
	private TipoPedido tipoPedido;
	private TipoPagamento tipoPagamento;
	private Double total;
	private String nomeCliente;
	
	public PedidoComNomeClienteDTO() {
		
	}

	public PedidoComNomeClienteDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.tipoPedido = pedido.getTipoPedido();
		this.tipoPagamento = pedido.getTipoPagamento();
		this.total = pedido.getTotal();
		this.nomeCliente = pedido.getCliente().getNome();
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

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	@Override
	public String toString() {
		return "PedidoComNomeClienteDTO [id=" + id + ", tipoPedido=" + tipoPedido + ", tipoPagamento=" + tipoPagamento
				+ ", total=" + total + ", nomeCliente=" + nomeCliente + "]";
	}
	
}
