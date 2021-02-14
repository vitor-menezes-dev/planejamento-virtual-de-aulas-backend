package br.com.planejamentovirtualaulas.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.planejamentovirtualaulas.domains.enums.Etapa;

@Entity
public class CampoExperiencia implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	@Column(length = 65535)
	private String detalhe;
	@Column(length = 65535)
	private String orientacao;
	@Column(length = 65535)
	private String direito;
	private Integer etapa;
	
	@JsonIgnore
	@OneToMany(mappedBy = "campoExperiencia")
	private List<BNCCInfantil> bnccs = new ArrayList<>();

	public CampoExperiencia() {
	}

	public CampoExperiencia(Integer id, String nome, String detalhe, String orientacao, String direito, Etapa etapa) {
		super();
		this.id = id;
		this.nome = nome;
		this.detalhe = detalhe;
		this.orientacao = orientacao;
		this.direito = direito;
		this.etapa = (etapa==null)? null : etapa.getCod();
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

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public String getOrientacao() {
		return orientacao;
	}

	public void setOrientacao(String orientacao) {
		this.orientacao = orientacao;
	}

	public String getDireito() {
		return direito;
	}

	public void setDireito(String direito) {
		this.direito = direito;
	}

	public Etapa getEtapa() {
		return Etapa.toEnum(etapa);
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa.getCod();
	}

	public List<BNCCInfantil> getBnccs() {
		return bnccs;
	}

	public void setBnccs(List<BNCCInfantil> bnccs) {
		this.bnccs = bnccs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CampoExperiencia other = (CampoExperiencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CampoExperiencia [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (nome != null) {
			builder.append("nome=");
			builder.append(nome);
			builder.append(", ");
		}
		if (detalhe != null) {
			builder.append("detalhe=");
			builder.append(detalhe);
			builder.append(", ");
		}
		if (orientacao != null) {
			builder.append("orientacao=");
			builder.append(orientacao);
			builder.append(", ");
		}
		if (direito != null) {
			builder.append("direito=");
			builder.append(direito);
		}
		builder.append("]");
		return builder.toString();
	}

}
