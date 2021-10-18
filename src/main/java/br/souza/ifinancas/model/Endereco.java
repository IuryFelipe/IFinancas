package br.souza.ifinancas.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Endereco extends DefaultEntity {
	
	@Column(nullable = false, length = 8)
	private String cep;
	@Column(nullable = false)
	private int numero;
	@Column(nullable = false)
	private String logradouro;
	@Column(nullable = false)
	private String complemento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Cidade cidade;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", numero=" + numero + ", logradouro=" + logradouro + ", complemento="
				+ complemento + ", cidade=" + cidade + "]";
	}
	
	
}
