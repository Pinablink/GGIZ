package br.com.ggiz.ggizWeb.repository.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@Entity
public class Gbroadcastctr {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String envbroad;
	private Date dtcriacao;
	private Date dtmanutencao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_gusuario", referencedColumnName = "id")
	private Gusuario gusuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnvbroad() {
		return envbroad;
	}

	public void setEnvbroad(String envbroad) {
		this.envbroad = envbroad;
	}

	public Date getDtcriacao() {
		return dtcriacao;
	}

	public void setDtcriacao(Date dtcriacao) {
		this.dtcriacao = dtcriacao;
	}

	public Date getDtmanutencao() {
		return dtmanutencao;
	}

	public void setDtmanutencao(Date dtmanutencao) {
		this.dtmanutencao = dtmanutencao;
	}

	public Gusuario getGusuario() {
		return gusuario;
	}

	public void setGusuario(Gusuario gusuario) {
		this.gusuario = gusuario;
	}
	
	
}
