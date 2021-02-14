package br.com.planejamentovirtualaulas.dtos;

import br.com.planejamentovirtualaulas.domains.BNCCInfantil;
import br.com.planejamentovirtualaulas.domains.enums.FaixaEtaria;

public class BNCCInfantilDTO{
	
	private String codigo;
	private String objetivo;
	private FaixaEtaria faixa;
	private CampoExperienciaDTO campoExperiencia;

	public BNCCInfantilDTO() {
	}

	public BNCCInfantilDTO(BNCCInfantil bncc) {
		this.codigo = bncc.getCodigo();
		this.objetivo = bncc.getObjetivo();
		this.faixa = bncc.getFaixa();
		this.campoExperiencia = new CampoExperienciaDTO(bncc.getCampoExperiencia());
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public FaixaEtaria getFaixa() {
		return faixa;
	}

	public void FaixaEtaria(FaixaEtaria faixa) {
		this.faixa = faixa;
	}

	public CampoExperienciaDTO getCampoExperiencia() {
		return campoExperiencia;
	}

	public void setCampoExperiencia(CampoExperienciaDTO campoExperiencia) {
		this.campoExperiencia = campoExperiencia;
	}


}
