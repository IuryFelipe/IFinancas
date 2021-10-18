package br.souza.ifinancas.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.souza.ifinancas.application.RepositoryException;
import br.souza.ifinancas.application.Util;
import br.souza.ifinancas.model.PessoaFisica;
import br.souza.ifinancas.model.Usuario;

public class PessoaFisicaRepository extends Repository<PessoaFisica> {
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() throws RepositoryException {
		try {
			EntityManager em = getEntityManager();
			Query query = em.createQuery("SELECT u FROM Usuario u");
			return query.getResultList();
		} catch (Exception e) {
			// TODO: handle exceptio
			return null;
		}
	}
	
	public PessoaFisica autenticaPessoaFisica(String email, String senha) throws RepositoryException {
		
		try { 
			EntityManager em = getEntityManager();
			String senhaCript = Util.hash(senha);
			TypedQuery<PessoaFisica> query = em.createQuery(""
					+ "SELECT u FROM PessoaFisica u "
					+ "WHERE "
					+ "u.email = :email AND "
					+ "u.senha = :senha", PessoaFisica.class);
			query.setParameter("email", email);
			query.setParameter("senha", senhaCript);
			return query.getSingleResult();
		} catch (NoResultException nrs) {
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Problema ao autenticar.");
		}
	}
}
