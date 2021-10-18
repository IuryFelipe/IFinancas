package br.souza.ifinancas.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.souza.ifinancas.application.Util;
import br.souza.ifinancas.model.Cidade;
import br.souza.ifinancas.model.Endereco;
import br.souza.ifinancas.model.Estado;
import br.souza.ifinancas.model.PessoaFisica;
import br.souza.ifinancas.model.PessoaJuridica;
import br.souza.ifinancas.model.Telefone;
import br.souza.ifinancas.model.enumeration.Perfil;
import br.souza.ifinancas.model.enumeration.Regiao;

public class PessoaJuridicaTest {

	public static void main(String[] args) {
		System.out.println("Inicio PessoaJuridicaTest");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFinancas");
		EntityManager em = emf.createEntityManager();
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		Endereco endereco = new Endereco();
		Estado estado = new Estado();
		Cidade cidade = new Cidade();
		Telefone telefone = new Telefone();
		Telefone telefone2 = new Telefone();
		Telefone telefone3 = new Telefone();
		Calendar cal = Calendar.getInstance();
		//Estado
		estado.setNome("Tocantins");
		estado.setRegiao(Regiao.NORTE);
		estado.setUf("TO");
		
		//Cidade
		cidade.setEstado(estado);
		cidade.setNome("Palmas");
		
		//Endereco
		endereco.setCep("7000000");
		endereco.setCidade(cidade);
		endereco.setNumero(0);
		endereco.setComplemento("Alguma coisa");
		endereco.setLogradouro("Alguma coisa");
		
		//Telefones
		telefone.setCodigoArea("61");
		telefone.setNumero("111111111");
		telefone2.setCodigoArea("63");
		telefone2.setNumero("22222222");
		telefone3.setCodigoArea("63");
		telefone3.setNumero("33333333");
		List<Telefone> listaTelefones = new ArrayList<Telefone>();
		listaTelefones.add(telefone);
		listaTelefones.add(telefone2);
		listaTelefones.add(telefone3);
		
		
		
		//Pessoa Juridica
		pessoaJuridica.setCnpj("129381723891737");
		
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date dataExpiracao = cal.getTime();
		pessoaJuridica.setDataExpiracao(dataExpiracao);
		
		pessoaJuridica.setEmail("iurycomputacao@gmail.com");
		pessoaJuridica.setImagem("kalsdJkaks9*");
		pessoaJuridica.setPerfil(Perfil.ADMINISTRADOR);
		pessoaJuridica.setEndereco(endereco);
		pessoaJuridica.setTelefones(listaTelefones);
		
		String hashSenha = Util.hash("123456");
		pessoaJuridica.setSenha(hashSenha);
		
		//Imprime os dados informados
		System.out.println("Dados informados: ");
		System.out.println(pessoaJuridica.toString());
		System.out.println(estado.toString());
		System.out.println(cidade.toString());
		System.out.println(endereco.toString());
		System.out.println(telefone.toString());
		
		em.getTransaction().begin();
		pessoaJuridica = em.merge(pessoaJuridica);
		em.getTransaction().commit();
		em.close();
		System.out.println("Finalizou o teste");

	}

}
