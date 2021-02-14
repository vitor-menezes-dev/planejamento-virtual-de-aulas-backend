package br.com.planejamentovirtualaulas.domains.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Etapa {
	INFANTIL(1, "Educação Infantil"),
	FUNDAMENTAL(2, "Ensino Fundamental"),
	MEDIO(2, "Ensino Médio");

	private int cod;
	private String descricao;

	private Etapa(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static Etapa toEnum(Integer id) {
		if (id == null) {
			return null;
		}
		for (Etapa x : Etapa.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
	
	
}
