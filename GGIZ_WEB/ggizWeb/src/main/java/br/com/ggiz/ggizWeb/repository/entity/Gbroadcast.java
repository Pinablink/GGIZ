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
public class Gbroadcast {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String message;
	private String msgenvbroad;	
	private Date dtcriacao;
	private Date dtmanutencao;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMsgenvbroad() {
		return msgenvbroad;
	}
	public void setMsgenvbroad(String msgenvbroad) {
		this.msgenvbroad = msgenvbroad;
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
	
	
	
}
