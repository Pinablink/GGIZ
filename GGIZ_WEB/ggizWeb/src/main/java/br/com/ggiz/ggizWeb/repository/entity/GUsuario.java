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
public class GUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long   id;
	private Long   id_gtpusuario;
	private String nome;
	private String senha;
	private String email;
	private String avatar;
	private Date   dataCriacao;
	private Date   dataManutencao;
	
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
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataManutencao() {
		return dataManutencao;
	}
	public void setDataManutencao(Date dataManutencao) {
		this.dataManutencao = dataManutencao;
	}
	
	@Override
	public String toString() {
		return "GUsuario [id=" + id + ", id_gtpusuario=" + id_gtpusuario + ", nome=" + nome + ", senha=" + senha
				+ ", email=" + email + ", avatar=" + avatar + ", dataCriacao=" + dataCriacao + ", dataManutencao="
				+ dataManutencao + "]";
	}
	
	
}
