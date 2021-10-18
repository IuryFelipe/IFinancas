package br.souza.ifinancas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Telefone extends DefaultEntity{
	
	@Column(nullable = false, length = 3)
	private String codigoArea;
	@Column(nullable = false, length = 20)
	private String numero;
	
	@Transient
	private String numeroCompleto;

	public String getCodigoArea() {
		return codigoArea;
	}

	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumeroCompleto() {
		return getCodigoArea() + getNumero();
	}

	@Override
	public String toString() {
		return "Telefone [codigoArea=" + codigoArea + ", numero=" + numero + ", numeroCompleto=" + numeroCompleto + "]";
	}	
	
	
	
}
