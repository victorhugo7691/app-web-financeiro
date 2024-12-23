package com.appweb.financeiro.banco.postgredb.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.appweb.financeiro.banco.exceptions.DadosNaoEncontradosException;
import com.appweb.financeiro.banco.postgredb.dto.input.LoginInputDTO;
import com.appweb.financeiro.banco.postgredb.dto.output.ContaDTO;
import com.appweb.financeiro.banco.postgredb.entity.Conta;
import com.appweb.financeiro.banco.postgredb.entity.SenhaDoUsuario;
import com.appweb.financeiro.banco.postgredb.repository.interfaces.ISenhaDoUsuarioRepository;
import com.appweb.financeiro.banco.postgredb.service.interfaces.ILoginService;

@Service
public class LoginService implements ILoginService {

	private ISenhaDoUsuarioRepository senhaRepository;

	private final PasswordEncoder passwordEncoder;

	public LoginService(ISenhaDoUsuarioRepository senhaRepository, PasswordEncoder passwordEncoder) {
		this.senhaRepository = senhaRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public ContaDTO realizarLogin(LoginInputDTO login) {
		SenhaDoUsuario senha = this.senhaRepository.findSenhaByConta(login.numeroDaConta());
		ContaDTO contaDeLogin = null;
		
		if(senha == null) {
			throw new DadosNaoEncontradosException("Verifique as informações de login!");
		}
		
		if (this.passwordEncoder.matches(login.senha(), senha.getSenha())) {
			Conta conta = senha.getConta();

			contaDeLogin =  new ContaDTO(conta.getNumeroDaConta(), conta.getSituacao().getDescricao(), conta.getSaldo(),
					conta.getId().toString());
		}
		
		return contaDeLogin;
	}
}
