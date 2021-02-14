package br.com.planejamentovirtualaulas.domains.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FaixaEtaria {
	BEBES(1, "Bebês (zero a 1 ano e 6 meses)"),
	CRIANCAS_BEM_PEQUENAS(2, "Crianças bem pequenas (1 ano e 7 meses a 3 anos e 11 meses)"),
	CRIANCAS_PEQUENAS(3, "Crianças pequenas (4 anos a 5 anos e 11 meses)");

	private int cod;
	private String descricao;

	private FaixaEtaria(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static FaixaEtaria toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (FaixaEtaria x : FaixaEtaria.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}
