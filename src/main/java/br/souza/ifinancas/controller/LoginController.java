package br.souza.ifinancas.controller;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.souza.ifinancas.application.RepositoryException;
import br.souza.ifinancas.application.Session;
import br.souza.ifinancas.application.Util;
import br.souza.ifinancas.model.Usuario;
import br.souza.ifinancas.model.enumeration.Perfil;
import br.souza.ifinancas.repository.LoginRepository;

@Named
@RequestScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = -7702846158103428365L;
	private String email;
	private String senha;
	
	public String autenticarUsuario() {
		try {
			LoginRepository loginRepository = new LoginRepository();
			Usuario usuarioLogado = new Usuario();
			usuarioLogado = loginRepository.findByNomeAndSenha(getEmail(), getSenha());
			System.out.println(usuarioLogado);
			if(usuarioLogado != null) {
				Date dataAtual = new Date();
				if(dataAtual.before(usuarioLogado.getDataExpiracao())) {
					//Util.addInfoMessage("Autenticado com sucesso");
					//Session.getInstance().set("usuarioLogado", usuarioLogado);
					/*
					if(usuarioLogado.getPerfil().equals(Perfil.TECNICO)) {
						return "emdesenvolvimento.xhtml?faces-redirect=true";
					}else {
						Util.addInfoMessage("Autenticado com sucesso");
						Session.getInstance().set("usuarioLogado", usuarioLogado);
						return "/pages/dashboard/index.xhtml?faces-redirect=true";
					}*/
					Util.addInfoMessage("Autenticado com sucesso");
					Session.getInstance().set("usuarioLogado", usuarioLogado);
					return "/pages/dashboard/index.xhtml?faces-redirect=true";
				}else {
					Util.addWarnMessage("Usuário com conta vencida");
					return null;
				}
			}else {
				Util.addErrorMessage("Usuário ou senha não encontrados");
				return null;
			}
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return  senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
}
