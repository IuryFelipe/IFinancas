package br.souza.ifinancas.controller;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.souza.ifinancas.application.RepositoryException;
import br.souza.ifinancas.application.Session;
import br.souza.ifinancas.application.Util;
import br.souza.ifinancas.dto.UsuarioLogadoDTO;
import br.souza.ifinancas.model.PessoaFisica;
import br.souza.ifinancas.model.PessoaJuridica;
import br.souza.ifinancas.model.Usuario;
import br.souza.ifinancas.model.enumeration.Perfil;
import br.souza.ifinancas.model.enumeration.TipoPessoa;
import br.souza.ifinancas.repository.PessoaFisicaRepository;
import br.souza.ifinancas.repository.PessoaJuridicaRepository;

@Named
@RequestScoped
public class LoginController implements Serializable{

	private static final long serialVersionUID = -7702846158103428365L;
	private String email;
	private String senha;
	private boolean pessoaJuridica;
	
	public String autenticarUsuario() {
		
		if(isPessoaJuridica()) {
			PessoaJuridicaRepository pessoaJuridicaRepository = new PessoaJuridicaRepository();
			PessoaJuridica pessoaJuridica= new PessoaJuridica();
			try {
				pessoaJuridica = pessoaJuridicaRepository.autenticaPessoaJuridica(getEmail(), getSenha());
				if(pessoaJuridica != null) {
					Date dataAtual = new Date();
					if(dataAtual.before(pessoaJuridica.getDataExpiracao())) {
						UsuarioLogadoDTO usuarioLogado = new UsuarioLogadoDTO();
						usuarioLogado.setDataExpiracao(pessoaJuridica.getDataExpiracao());
						usuarioLogado.setEmail(pessoaJuridica.getEmail());
						usuarioLogado.setId(pessoaJuridica.getId());
						usuarioLogado.setSenha(pessoaJuridica.getSenha());
						usuarioLogado.setNome(pessoaJuridica.getCnpj());
						usuarioLogado.setPerfil(pessoaJuridica.getPerfil());
						usuarioLogado.setTipoPessoa(TipoPessoa.JURIDICA);
						Util.addInfoMessage("Autenticado com sucesso");
						Session.getInstance().set("usuarioLogado", usuarioLogado);

						return "/pages/dashboard/index.xhtml?faces-redirect=true";
					} else {
						Util.addWarnMessage("Usuário com conta vencida");
						return null;
					}
				}else {
					Util.addErrorMessage("Usuário ou senha não encontrados");
					return null;
				}
				
			} catch (Exception e) {
				return null;
			}
		} else {
			//para pessoa fisica
			PessoaFisicaRepository pessoaFisicaRepository = new PessoaFisicaRepository();
			PessoaFisica pessoaFisica = new PessoaFisica();
			
			try {
				pessoaFisica = pessoaFisicaRepository.autenticaPessoaFisica(getEmail(), getSenha());
				if(pessoaFisica != null) {
					Date dataAtual = new Date();
					if(dataAtual.before(pessoaFisica.getDataExpiracao())) { 
						UsuarioLogadoDTO usuarioLogado = new UsuarioLogadoDTO();
						usuarioLogado.setDataExpiracao(pessoaFisica.getDataExpiracao());
						usuarioLogado.setEmail(pessoaFisica.getSenha());
						usuarioLogado.setId(pessoaFisica.getId());
						usuarioLogado.setNome(pessoaFisica.getNome());
						usuarioLogado.setSenha(pessoaFisica.getSenha());
						usuarioLogado.setPerfil(pessoaFisica.getPerfil());
						usuarioLogado.setTipoPessoa(TipoPessoa.FISICA);
						Util.addInfoMessage("Autenticado com sucesso");
						Session.getInstance().set("usuarioLogado", usuarioLogado);

						return "/pages/dashboard/index.xhtml?faces-redirect=true";
					} else {
						Util.addWarnMessage("Usuário com conta vencida");
						return null;
					}
				} else {
					Util.addErrorMessage("Usuário ou senha não encontrados");
					return null;
				}
			} catch (Exception e) {
				return null;
			}
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


	public boolean isPessoaJuridica() {
		return pessoaJuridica;
	}


	public void setPessoaJuridica(boolean pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}
	
}
