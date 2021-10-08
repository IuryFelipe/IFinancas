package br.souza.ifinancas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import br.souza.ifinancas.model.enumeration.Perfil;

@Entity
public class Usuario extends DefaultEntity{
	
	@Column(nullable = false, length = 30, name = "primeiro_nome")
	private String primeiroNome;
	
	@Column(nullable = true, length = 30)
	private String sobrenome;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@Transient
	private String nomeCompleto;
	
	@Column(nullable = false)
	private Date dataExpiracao;
	
	@Column(nullable = false, length = 500)
	private String senha;
	
	@Column(nullable = false)
	private Perfil perfil;

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCompleto() {
		return getPrimeiroNome() + " " + getSobrenome();
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario [primeiroNome=" + primeiroNome + ", sobrenome=" + sobrenome + ", email=" + email
				+ ", nomeCompleto=" + nomeCompleto + ", dataExpiracao=" + dataExpiracao + ", senha=" + senha
				+ ", perfil=" + perfil + "]";
	}
	
	
}
