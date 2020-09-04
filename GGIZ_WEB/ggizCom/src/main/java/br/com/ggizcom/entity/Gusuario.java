package br.com.ggizcom.entity;

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
public class Gusuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long id_gtpusuario;
	private String nome;
	private String senha;
	private String email;
	private String avatar;
	private Date dtcriacao;
	private Date dtmanutencao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_gtpusuario() {
		return id_gtpusuario;
	}
	public void setId_gtpusuario(Long id_gtpusuario) {
		this.id_gtpusuario = id_gtpusuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
		return "Gusuario [id=" + id + ", id_gtpusuario=" + id_gtpusuario + ", nome=" + nome + ", senha=" + senha
				+ ", email=" + email + ", avatar=" + avatar + ", dtcriacao=" + dtcriacao + ", dtmanutencao="
				+ dtmanutencao + "]";
	}
	
}
