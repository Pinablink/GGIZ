package br.com.ggiz.ggizWeb.repository.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@Entity
public class Gnoticialer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long id_gnoticia;
	private String texto;
	private Date dtcriacao;
	private Date dtmanutencao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_gnoticia() {
		return id_gnoticia;
	}
	public void setId_gnoticia(Long id_gnoticia) {
		this.id_gnoticia = id_gnoticia;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
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
	
	@Override
	public String toString() {
		return "Gnoticialer [id=" + id + ", id_gnoticia=" + id_gnoticia + ", texto=" + texto + ", dtcriacao="
				+ dtcriacao + ", dtmanutencao=" + dtmanutencao + "]";
	}
	
	
}
