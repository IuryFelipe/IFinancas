package br.souza.ifinancas.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.souza.ifinancas.application.RepositoryException;
import br.souza.ifinancas.application.Util;
import br.souza.ifinancas.model.Usuario;

public class LoginRepository extends Repository<Usuario>{
	
	public Usuario findByNomeAndSenha(String email, String senha) throws RepositoryException {
		
		try { 
			EntityManager em = getEntityManager();
			String senha2 = Util.hash(senha);
			TypedQuery<Usuario> query = em.createQuery(""
					+ "SELECT u FROM Usuario u "
					+ "WHERE "
					+ "u.email = :email AND "
					+ "u.senha = :senha", Usuario.class);
			query.setParameter("email", email);
			query.setParameter("senha", senha2);
			return query.getSingleResult();
		} catch (NoResultException nrs) {
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Problema ao autenticar.");
		}
	}
}
