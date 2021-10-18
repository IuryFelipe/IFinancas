package br.souza.ifinancas.test;

import br.souza.ifinancas.application.RepositoryException;
import br.souza.ifinancas.application.Util;
import br.souza.ifinancas.model.PessoaFisica;
import br.souza.ifinancas.model.PessoaJuridica;
import br.souza.ifinancas.model.Usuario;
import br.souza.ifinancas.repository.PessoaFisicaRepository;
import br.souza.ifinancas.repository.PessoaJuridicaRepository;

public class LoginTest {
	public static void main(String[] args) throws RepositoryException {
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		PessoaFisica pessoaFisica = new PessoaFisica();
		PessoaJuridicaRepository loginPessoaJuridicaRepository = new PessoaJuridicaRepository();
		PessoaFisicaRepository loginPessoafisicaRepository = new PessoaFisicaRepository();
		
		String senha = "123456";
		String email = "iurycomputacao@gmail.com";
		boolean isPessoaJuridica = true;
		
		if(isPessoaJuridica) {
			pessoaJuridica = loginPessoaJuridicaRepository.autenticaPessoaJuridica(email, senha);
			System.out.println(pessoaJuridica.toString());
			
			
		}else {
			pessoaFisica = loginPessoafisicaRepository.autenticaPessoaFisica(email, senha);
			System.out.println(pessoaFisica.toString());
		}
		
	}
}
