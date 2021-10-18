package br.souza.ifinancas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class PessoaFisica extends Usuario{
	
	@Column(length = 100)
	private String nome;
	@Column(length = 100)
	private String sobrenome;
	private Date dataNascimento;
	
	@Transient
	private String nomeCompleto;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getNomeCompleto() {
		return getNome() + " "+ getSobrenome();
	}
	
	@Override
	public String toString() {
		return "PessoaFisica [nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento=" + dataNascimento
				+ ", nomeCompleto=" + getNomeCompleto() +"]";
	}
	
	
}
