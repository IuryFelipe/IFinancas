package br.souza.ifinancas.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.souza.ifinancas.application.Session;
import br.souza.ifinancas.dto.UsuarioLogadoDTO;
import br.souza.ifinancas.model.Usuario;

@Named
@ViewScoped
public class TemplateController implements Serializable{
	
	private static final long serialVersionUID = -6348335687251161172L;
	private UsuarioLogadoDTO usuarioLogado;
	
	public String encerrarSessao() {
		Session.getInstance().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}
	
	public UsuarioLogadoDTO getUsuarioLogado() {
		//System.out.println("Verificou se usuário está logado");
		//System.out.println("Sessão atual: "+Session.getInstance().get("usuarioLogado"));
		// Obtendo o usuário da sessão
		if (usuarioLogado == null) {
			usuarioLogado = (UsuarioLogadoDTO) Session.getInstance().get("usuarioLogado");
		}
		return usuarioLogado;
	}

	public void setUsuarioLogadoDTO(UsuarioLogadoDTO usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}
