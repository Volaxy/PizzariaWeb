package br.com.etaure.entities.enums;

public enum TamanhoDaPizza {

	PEQUENA(1, "Pequena"),
	MEDIA(2, "Media"),
	GRANDE(3, "Grande");
	
	private Integer code;
	private String descricao;
	
	private TamanhoDaPizza(Integer code, String descricao) {
		this.code = code;
		this.descricao = descricao;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TamanhoDaPizza toEnum(Integer code) {
		if(code == null) {
			return null;
		} else {
			for (TamanhoDaPizza tamanho : TamanhoDaPizza.values()) {
				if(code.equals(tamanho.getCode())) {
					return tamanho;
				}
			}
		}
		
		throw new IllegalArgumentException("Código Inválido: " + code);
	}
	
}
