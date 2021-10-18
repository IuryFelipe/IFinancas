package br.souza.ifinancas.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.souza.ifinancas.application.Util;
import br.souza.ifinancas.model.Usuario;
import br.souza.ifinancas.model.enumeration.Perfil;
import br.souza.ifinancas.repository.UsuarioRepository;

@Named
@ViewScoped
public class EditarUsuarioController implements Serializable{
	
	private static final long serialVersionUID = 8624831635129847965L;
	private Usuario usuario;
	private String confirmarSenha = "";
	private boolean vazio = true;
	/*
	public EditarUsuarioController() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.keep("usuarioEdicaoFlash");
		if(flash.get("usuarioEdicaoFlash") == null) {
			setVazio(true);
			System.out.println("Não veio nenhum usuário");
			Util.addWarnMessage("Selecione o usuário primeiro...");
		}else {
			setUsuario((Usuario)flash.get("usuarioEdicaoFlash"));
			setVazio(false);
		}
	}
	
	
	public void limpar() {
		System.out.println("Limpar");
		setUsuario(null);
	}
	public Perfil[] getListaPerfil() {
		return Perfil.values();
	}
	
	public Usuario getUsuario() {
		if(usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public boolean isVazio() {
		return vazio;
	}

	public void setVazio(boolean vazio) {
		this.vazio = vazio;
	}
	*/
}
