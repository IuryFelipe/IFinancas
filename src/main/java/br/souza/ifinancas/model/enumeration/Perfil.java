package br.souza.ifinancas.model.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum Perfil {
	ADMINISTRADOR(1, "Administrador"),
	TECNICO(2, "Tecnico");
	
	private int value;
	private String label;
	private List<String> paginasAcesso = null;
	
	private Perfil (int value, String label) {
		this.value = value;
		this.label = label;
		paginasAcesso = new ArrayList<String>();
		if (value == 1) {
			//Permissões de acesso de administrador
			paginasAcesso.add("usuarios/index.xhtml");
			paginasAcesso.add("usuarios/cadastrar/index.xhtml");
			paginasAcesso.add("usuarios/editar/index.xhtml");
			paginasAcesso.add("dashboard/index.xhtml");
			paginasAcesso.add("despesas/index.xhtml");
			paginasAcesso.add("plano-de-conta/index.xhtml");
			paginasAcesso.add("plano-de-conta/cadastrar/index.xhtml");
			paginasAcesso.add("plano-de-conta/editar/index.xhtml");
			paginasAcesso.add("plano-de-conta/lancamentos/index.xhtml");
			paginasAcesso.add("receitas/index.xhtml");
			paginasAcesso.add("relatorios/index.xhtml");

		} else {
			//permissões de acesso de aluno
			paginasAcesso.add("plano-de-conta/index.xhtml");
			paginasAcesso.add("plano-de-conta/cadastrar/index.xhtml");
			paginasAcesso.add("plano-de-conta/editar/index.xhtml");
			paginasAcesso.add("plano-de-conta/lancamentos/index.xhtml");
			paginasAcesso.add("dashboard/index.xhtml");
			paginasAcesso.add("despesas/index.xhtml");
			paginasAcesso.add("receitas/index.xhtml");
			paginasAcesso.add("relatorios/index.xhtml");
		}
	}
	
	public List<String> getPaginasAcesso() {
		return paginasAcesso;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getLabel() {
		return label;
	}
	
	
	public static Perfil valueOf(Integer value) {
		if (value == null)
			return null;
		
		for (Perfil perfil : values()) {
			if (perfil.getValue() == value) {
				return perfil;
			}
		}
		return null;
	}
}
