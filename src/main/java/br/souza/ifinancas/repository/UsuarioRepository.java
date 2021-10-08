package br.souza.ifinancas.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.souza.ifinancas.application.RepositoryException;
import br.souza.ifinancas.model.Usuario;

public class UsuarioRepository extends Repository<Usuario>{
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findByNome(String nome) throws RepositoryException {
		try { 
			EntityManager em = getEntityManager();
			//JPQL ou SQL
			Query query = em.createQuery("SELECT u FROM Usuario u WHERE upper(u.primeiroNome) LIKE upper(:nome)");
			query.setParameter("nome", "%" + nome + "%");
			
			return query.getResultList();
		} catch (Exception e) {
			// mandando pro console o exception gerado
			e.printStackTrace();
			// repassando a excecao para quem vai executar o metodo
			throw new RepositoryException("Problema ao pesquisar usuários.");
		}
	}
	
	
	public boolean findByEmail(String email) throws RepositoryException {
		try {
			EntityManager em = getEntityManager();
			//JPQL ou SQL
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE upper(u.email) LIKE upper(:email)", Usuario.class);
			query.setParameter("email", "%" + email + "%");
			
			query.getSingleResult();
			return true;
			
		} catch (NoResultException e) {
			return false;
		}
	}
}
