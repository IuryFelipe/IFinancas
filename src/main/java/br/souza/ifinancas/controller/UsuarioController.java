package br.souza.ifinancas.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.souza.ifinancas.application.RepositoryException;
import br.souza.ifinancas.model.Usuario;
import br.souza.ifinancas.model.enumeration.Perfil;
import br.souza.ifinancas.repository.UsuarioRepository;

@Named
@ViewScoped
public class UsuarioController implements Serializable{

	private static final long serialVersionUID = 8712536320080126823L;
	private Usuario usuario = null;
	private String confirmarSenha;
	private List<Usuario> listaUsuario = null;
	private Usuario usuarioSelecionado = null;
	
	public String editar(Usuario usu) {
		//UsuarioDAO dao = new UsuarioDAO();
		//Usuario usuario = dao.obterUm(usu.getId());
		//Flash flash =  FacesContext.getCurrentInstance().getExternalContext().getFlash();
		//flash.put("usuarioEdicaoFlash", usuario);	
		//return "/pages/usuarios/editar/index.xhtml?faces-redirect=true";
		return null;//apagar em produção
	}
	

	public Perfil[] getListaPerfil() {
		return Perfil.values();
	}
	
	public Usuario getUsuario() {
		if (usuario == null) {
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
	
	
	public List<Usuario> getListaUsuario() throws RepositoryException {
		if (listaUsuario == null) {
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			listaUsuario = usuarioRepository.getAll(Usuario.class);
			if (listaUsuario == null)
				listaUsuario = new ArrayList<Usuario>();
		}
		//System.out.println(listaUsuario.toString());
		return listaUsuario;
	}
	
	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Usuario getUsuarioSelecionado() {
		if(usuarioSelecionado == null) {
			usuarioSelecionado = new Usuario();
		}
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
	
	public void deleteUsuario() {
		listaUsuario.remove(usuarioSelecionado);
		usuarioSelecionado = null;
    }
	
}
