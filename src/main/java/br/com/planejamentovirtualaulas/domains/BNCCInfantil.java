package br.com.planejamentovirtualaulas.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.planejamentovirtualaulas.domains.enums.FaixaEtaria;

@Entity
public class BNCCInfantil implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String codigo;
	@Column(length = 65535)
	private String objetivo;
	@Column(length = 65535)
	private String abordagem;
	@Column(length = 65535)
	private String sugestao;
	private Integer faixa;

	@ManyToOne
	@JoinColumn(name = "campoExperiencia_id")
	private CampoExperiencia campoExperiencia;

	public BNCCInfantil() {
	}

	public BNCCInfantil(String codigo, String objetivo, String abordagem, String sugestao, FaixaEtaria faixa,
			CampoExperiencia campoExperiencia) {
		this.codigo = codigo;
		this.objetivo = objetivo;
		this.abordagem = abordagem;
		this.sugestao = sugestao;
		this.faixa = (faixa == null) ? null : faixa.getCod();
		this.campoExperiencia = campoExperiencia;
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

	public String getAbordagem() {
		return abordagem;
	}

	public void setAbordagem(String abordagem) {
		this.abordagem = abordagem;
	}

	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	public FaixaEtaria getFaixa() {
		return FaixaEtaria.toEnum(faixa);
	}

	public void setFaixa(FaixaEtaria faixa) {
		this.faixa = faixa.getCod();
	}

	public CampoExperiencia getCampoExperiencia() {
		return campoExperiencia;
	}

	public void setCampoExperiencia(CampoExperiencia campoExperiencia) {
		this.campoExperiencia = campoExperiencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BNCCInfantil other = (BNCCInfantil) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BNCCInfantil [");
		if (codigo != null) {
			builder.append("codigo=");
			builder.append(codigo);
			builder.append(", ");
		}
		if (objetivo != null) {
			builder.append("objetivo=");
			builder.append(objetivo);
			builder.append(", ");
		}
		if (abordagem != null) {
			builder.append("abordagem=");
			builder.append(abordagem);
			builder.append(", ");
		}
		if (sugestao != null) {
			builder.append("sugestao=");
			builder.append(sugestao);
			builder.append(", ");
		}
		if (faixa != null) {
			builder.append("faixa=");
			builder.append(faixa);
			builder.append(", ");
		}
		if (campoExperiencia != null) {
			builder.append("campoExperiencia=");
			builder.append(campoExperiencia);
		}
		builder.append("]");
		return builder.toString();
	}

}
