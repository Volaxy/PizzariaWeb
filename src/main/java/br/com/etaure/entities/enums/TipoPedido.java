package br.com.etaure.entities.enums;

public enum TipoPedido {

	ENTREGA(1, "Entrega"),
	PRESENCIAL(2, "Presencial");
	
	private Integer code;
	private String descricao;
	
	private TipoPedido(Integer code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public TipoPedido toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for (TipoPedido tipoPedido : TipoPedido.values()) {
			if(code.equals(tipoPedido.getCode())) {
				return tipoPedido;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + code);
	}
	
}
