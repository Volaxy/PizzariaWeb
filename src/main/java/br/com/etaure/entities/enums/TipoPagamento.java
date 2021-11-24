package br.com.etaure.entities.enums;

public enum TipoPagamento {

	DINHEIRO(1, "Dinheiro"),
	CARTAO(2, "Cartão");
	
	private Integer code;
	private String descricao;
	
	private TipoPagamento(Integer code, String descricao) {
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
	
	public TipoPagamento toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		
		for (TipoPagamento tipoPagamento : TipoPagamento.values()) {
			if(code.equals(tipoPagamento.getCode())) {
				return tipoPagamento;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + code);
	}
	
}
