package br.souza.ifinancas.filter;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.souza.ifinancas.model.Usuario;

@WebFilter(filterName = "SecurityFilter", urlPatterns = {"/pages/*"})
public class SecurityFilter implements Filter{
	public void destroy() {
	       // TODO Auto-generated method stub
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// deixando o fluxo seguir
		// Para desabilitar o filtro descomente as duas proximas linhas e comente o restante
//		chain.doFilter(request, response);
//		return;
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		String endereco = servletRequest.getRequestURI();
		System.out.println(endereco);
		
		if (endereco != null) {
			int inicio = endereco.lastIndexOf("/pages/") + 7;
			int fim = endereco.length();
			System.out.println("Endereco antes: "+endereco);
			endereco = endereco.substring(inicio, fim);
			System.out.println("Endereco depois: "+endereco);
		}
		
		
		// caso seja a pagina de login .. nao sera feita nenhuma restricao
		// deixo o fluxo seguir
		if (endereco.equals("login.xhtml") || servletRequest.getRequestURI().matches(".*(css|jpg|png|gif|js)")) {
			chain.doFilter(request, response);
			return;
		}
		
		// retorna uma sessao corrente (false - nao cria uma sessao)
		HttpSession session = servletRequest.getSession(false);
		
		Usuario usuario = null;
		if (session != null) 
			usuario = (Usuario) session.getAttribute("usuarioLogado");
		
		if (usuario == null) {
			((HttpServletResponse) response).sendRedirect("/IFinancas/login.xhtml");
		} else {
			System.out.println("Solicitando acesso em: "+endereco);
			if(usuario.getPerfil().getPaginasAcesso().contains(endereco)) {
				//segue o fluxo
				chain.doFilter(request, response);
				return;
			} else {
				//usuario não tem permissão para acessar a página solicitada
				((HttpServletResponse) response).sendRedirect("/IFinancas/SEM-PERMISSAO.xhtml");
			}
			
			chain.doFilter(request, response);
			return;
		}
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Security inicializado ...");
		
		Filter.super.init(filterConfig);
	}
}
