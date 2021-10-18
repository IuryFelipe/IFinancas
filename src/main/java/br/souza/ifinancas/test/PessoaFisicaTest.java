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
import br.souza.ifinancas.model.Telefone;
import br.souza.ifinancas.model.enumeration.Perfil;
import br.souza.ifinancas.model.enumeration.Regiao;

public class PessoaFisicaTest {

	public static void main(String[] args) {
		System.out.println("Inicio PessoaFisicaTest");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("IFinancas");
		EntityManager em = emf.createEntityManager();
		
		PessoaFisica pessoaFisica = new PessoaFisica();
		Endereco endereco = new Endereco();
		Estado estado = new Estado();
		Cidade cidade = new Cidade();
		Telefone telefone = new Telefone();
		Telefone telefone2 = new Telefone();
		Calendar cal = Calendar.getInstance();
		//Estado
		estado.setNome("Ceará");
		estado.setRegiao(Regiao.NORDESTE);
		estado.setUf("CE");
		
		//Cidade
		cidade.setEstado(estado);
		cidade.setNome("Fortaleza");
		
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
		List<Telefone> listaTelefones = new ArrayList<Telefone>();
		listaTelefones.add(telefone);
		listaTelefones.add(telefone2);
		
		
		
		//Pessoa Fisica
		pessoaFisica.setNome("Iury");
		pessoaFisica.setSobrenome("Souza");
		
		cal.set(Calendar.YEAR, 2021);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		Date dataExpiracao = cal.getTime();
		pessoaFisica.setDataExpiracao(dataExpiracao);
		
		cal.set(Calendar.YEAR, 1995);
		cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
		cal.set(Calendar.DAY_OF_MONTH, 23);
		Date dataNascimento = cal.getTime();
		pessoaFisica.setDataNascimento(dataNascimento);
		
		pessoaFisica.setEmail("iury.com");
		pessoaFisica.setImagem("kalsdJkaks9*");
		pessoaFisica.setPerfil(Perfil.ADMINISTRADOR);
		pessoaFisica.setEndereco(endereco);
		pessoaFisica.setTelefones(listaTelefones);
		
		String hashSenha = Util.hash("123456");
		pessoaFisica.setSenha(hashSenha);
		
		//Imprime os dados informados
		System.out.println("Dados informados: ");
		System.out.println(pessoaFisica.toString());
		System.out.println(estado.toString());
		System.out.println(cidade.toString());
		System.out.println(endereco.toString());
		System.out.println(telefone.toString());
		
		em.getTransaction().begin();
		pessoaFisica = em.merge(pessoaFisica);
		em.getTransaction().commit();
		em.close();
		System.out.println("Finalizou o teste");
	}

}
