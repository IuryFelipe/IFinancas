package br.souza.ifinancas.dto;

import java.util.Date;

import javax.inject.Named;

import br.souza.ifinancas.model.enumeration.Perfil;
import br.souza.ifinancas.model.enumeration.TipoPessoa;

@Named
public class UsuarioLogadoDTO {
	private Integer id; 
	private String email;
	private String senha;
	private String nome;
	private Date dataExpiracao;
	private Perfil perfil;
	private TipoPessoa tipoPessoa;
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
}
