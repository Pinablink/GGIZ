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
	
	 private Long id; 
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
	 
	 @Override
 	 public String toString() {
		return "GGNoticiaResponseDTO [id=" + id + ", descricao=" + descricao + ", dtcriacao=" + dtcriacao + "]";
	 }
	 
}
