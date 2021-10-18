package br.souza.ifinancas.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.souza.ifinancas.application.RepositoryException;
import br.souza.ifinancas.application.Util;
import br.souza.ifinancas.model.PessoaJuridica;
import br.souza.ifinancas.model.Usuario;

public class PessoaJuridicaRepository extends Repository<PessoaJuridica>{
	
	public PessoaJuridica autenticaPessoaJuridica(String email, String senha) throws RepositoryException {
		
		try { 
			EntityManager em = getEntityManager();
			String senhaCript = Util.hash(senha);
			TypedQuery<PessoaJuridica> query = em.createQuery(""
					+ "SELECT u FROM PessoaJuridica u "
					+ "WHERE "
					+ "u.email = :email AND "
					+ "u.senha = :senha", PessoaJuridica.class);
			query.setParameter("email", email);
			query.setParameter("senha", senhaCript);
			return query.getSingleResult();
		} catch (NoResultException nrs) {
			System.out.println("Entrou no NoResultException");
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Problema ao autenticar.");
		}
	}
}
