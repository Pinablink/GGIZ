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
public class Gnoticia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id; 
	 private String titulo;
	 private String descricao;
	 private Date dtcriacao;
     private Date dtmanutencao;
     
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		return "Gnoticia [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", dtcriacao=" + dtcriacao
				+ ", dtmanutencao=" + dtmanutencao + "]";
	}
     
}
