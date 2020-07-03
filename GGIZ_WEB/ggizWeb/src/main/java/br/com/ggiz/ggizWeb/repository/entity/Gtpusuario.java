package br.com.ggiz.ggizWeb.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Weber Alves dos Santos (Pinablink)
 *
 */
@Entity
public class Gtpusuario {
	
	@Id
	private Long id;
	private String descricao;
	
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
	
	@Override
	public String toString() {
		return "GTpUsuario [id=" + id + ", descricao=" + descricao + "]";
	}

}
