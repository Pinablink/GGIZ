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
public class Gusersysenv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String usersys;
	private String seedjwt;
	private Date dtcriacao;
	private Date dtmanutencao;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsersys() {
		return usersys;
	}
	
	public void setUsersys(String usersys) {
		this.usersys = usersys;
	}
	
	public String getSeedjwt() {
		return seedjwt;
	}
	
	public void setSeedjwt(String seedjwt) {
		this.seedjwt = seedjwt;
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
		return "Gusersysenv [id=" + id + ", usersys=" + usersys + ", seedjwt=" + seedjwt + ", dtcriacao=" + dtcriacao
				+ ", dtmanutencao=" + dtmanutencao + "]";
	}
	
	
}
