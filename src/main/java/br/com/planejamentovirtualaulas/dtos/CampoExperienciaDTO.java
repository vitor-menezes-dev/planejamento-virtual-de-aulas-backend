package br.com.planejamentovirtualaulas.dtos;

import br.com.planejamentovirtualaulas.domains.CampoExperiencia;
import br.com.planejamentovirtualaulas.domains.enums.Etapa;

public class CampoExperienciaDTO {

	private Integer id;
	private String nome;
	private Etapa etapa;

	public CampoExperienciaDTO() {
	}

	public CampoExperienciaDTO(CampoExperiencia campoExperiencia) {
		super();
		this.id = campoExperiencia.getId();
		this.nome = campoExperiencia.getNome();
		this.etapa = campoExperiencia.getEtapa();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

}
