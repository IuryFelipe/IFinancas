package br.souza.ifinancas.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.souza.ifinancas.application.RepositoryException;
import br.souza.ifinancas.application.Util;
import br.souza.ifinancas.model.Usuario;
import br.souza.ifinancas.model.enumeration.Perfil;
import br.souza.ifinancas.repository.UsuarioRepository;

@Named
@RequestScoped
public class NovoUsuarioController implements Serializable{

	private static final long serialVersionUID = 6587891921400730169L;
	private Usuario usuario = null;
	private String confirmarSenha = "";
	/*
	public String cadastrar() {
		if (!verificaSenha()) {
			Util.addErrorMessage("As senhas precisam ser iguais!");
			return null;
		}else {
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			String senha = Util.hash(getUsuario().getSenha()); //criptografando a senha
			getUsuario().setSenha(senha);
			try {
				if(usuarioRepository.findByEmail(getUsuario().getEmail())) {
					Util.addWarnMessage("Este email já está cadastrado no sistema...");
					return null;
				}else {
					
					usuarioRepository.create(getUsuario());
					limpar();
					Util.addInfoMessage("Usuário cadastrado com sucesso");
					return "/pages/usuarios/index.xhtml?faces-redirect=true";
				}
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Util.addErrorMessage("Erro durante cadastro");
				return null;
			}
		}
	}
	
	public void limpar() {
		setUsuario(null);
	}
	
	private boolean verificaSenha() {
		if (getUsuario().getSenha().equals(getConfirmarSenha())) {
			return true;
		}
		return false;
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
	*/
}
