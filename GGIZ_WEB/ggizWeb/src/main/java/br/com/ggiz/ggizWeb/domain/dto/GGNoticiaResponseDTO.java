package br.com.ggiz.ggizWeb.domain.dto;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
public class GGNoticiaResponseDTO 
		 implements Serializable {
	
	 /**
	 * 
	 */
	 private static final long serialVersionUID = -3308396211765200233L;
	 private Long id; 
	 private String titulo;
	 private String descricao;
	 private String dtcriacao;
	 
	 public Long getId() {
		return id;
	 }
	 public void setId(Long id) {
		this.id = id;
	 }
	 public String getDescricao() {
		return descricao;
	 }
	 public void setDescricao(String descricao) {
		this.descricao = descricao;
	 }
	 public String getDtcriacao() {
		return dtcriacao;
	 }
	 public void setDtcriacao(String dtcriacao) {
		this.dtcriacao = dtcriacao;
	 }
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public String toString() {
		return "GGNoticiaResponseDTO [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", dtcriacao="
				+ dtcriacao + "]";
	}
	 
	
	 
}
