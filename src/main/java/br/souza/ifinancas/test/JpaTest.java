package br.souza.ifinancas.test;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.souza.ifinancas.application.Util;
import br.souza.ifinancas.model.Usuario;
import br.souza.ifinancas.model.enumeration.Perfil;
import br.souza.ifinancas.repository.LoginRepository;

public class JpaTest {

	public static void main(String[] args) {
		System.out.println("Inicio");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFinancas");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = new Usuario();
		usuario.setPrimeiroNome("Iury");
		usuario.setSobrenome("Souza");
		usuario.setEmail("iurycomputacao@gmail.com");
		String hashSenha = Util.hash("123456");
		usuario.setPerfil(Perfil.ADMINISTRADOR);
		usuario.setSenha(hashSenha);
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date dataExpiracao = cal.getTime(); //Date está depreciado
		usuario.setDataExpiracao(dataExpiracao);

		em.getTransaction().begin();
		usuario = em.merge(usuario);
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Fim");
		
		
	}

}
