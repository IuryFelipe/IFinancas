package br.souza.ifinancas.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.souza.ifinancas.model.enumeration.Regiao;

@Entity
public class Estado extends DefaultEntity{
	@Column(nullable = false, length = 50, unique = true)
	private String nome;
	@Column(nullable = false, length = 2)
	private String uf;
	
	private Regiao regiao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	@Override
	public String toString() {
		return "Estado [nome=" + nome + ", uf=" + uf + ", regiao=" + regiao + "]";
	}
	
	
	
}
