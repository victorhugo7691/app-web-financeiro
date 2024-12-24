package com.appweb.financeiro.banco.postgredb.service;

import org.springframework.stereotype.Service;

import com.appweb.financeiro.banco.exceptions.FalhaNaAtividadeException;
import com.appweb.financeiro.banco.postgredb.dto.input.CadastroFormDTO;
import com.appweb.financeiro.banco.postgredb.entity.Cliente;
import com.appweb.financeiro.banco.postgredb.entity.Conta;
import com.appweb.financeiro.banco.postgredb.entity.SenhaDoUsuario;
import com.appweb.financeiro.banco.postgredb.enuns.ESituacaoDaConta;
import com.appweb.financeiro.banco.postgredb.repository.interfaces.ISenhaDoUsuarioRepository;
import com.appweb.financeiro.banco.postgredb.service.interfaces.ICadastroService;
import com.appweb.financeiro.banco.postgredb.service.interfaces.IClienteService;
import com.appweb.financeiro.banco.postgredb.service.interfaces.IContaService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CadastroService implements ICadastroService {

	private IClienteService clienteService;

	private IContaService contaService;

	private ISenhaDoUsuarioRepository senhaRepository;

	//private final PasswordEncoder passwordEncoder;

	public CadastroService(IClienteService clienteService, IContaService contaService,
			ISenhaDoUsuarioRepository senhaRepository) {
		this.clienteService = clienteService;
		this.contaService = contaService;
		this.senhaRepository = senhaRepository;
		//this.passwordEncoder = passwordEncoder;
	}

	@Override
	public void cadastrarCliente(CadastroFormDTO form) {
		Cliente cliente = new Cliente();

		cliente.setNome(form.getNomeDoCliente());
		cliente.setEmail(form.getEmail());
		cliente.setIdade(form.getIdade());

		try {
			cliente = this.clienteService.save(cliente);
		} catch (FalhaNaAtividadeException exception) {
			throw new FalhaNaAtividadeException("Falhou ao salvar o cliente");
		}
		this.cadastrarConta(form, cliente);
	}

	public void cadastrarConta(CadastroFormDTO form, Cliente cliente) {
		Conta conta = new Conta();

		conta.setCliente(cliente);
		conta.setNumeroDaConta(form.getNumeroDaConta());
		conta.setSaldo(0.0f);
		conta.setSituacao(ESituacaoDaConta.ATIVA);

		try {
			this.contaService.save(conta);
		} catch (FalhaNaAtividadeException exception) {
			throw new FalhaNaAtividadeException("Falhou ao salvar a conta");
		}
		
		this.cadastrarSenha(conta, form.getSenha());
	}

	public void cadastrarSenha(Conta conta, String senha) {
		SenhaDoUsuario novaSenha = new SenhaDoUsuario();
		novaSenha.setConta(conta);
		novaSenha.setSenha(senha);

		try {
			this.senhaRepository.save(novaSenha);
		} catch (FalhaNaAtividadeException exception) {
			throw new FalhaNaAtividadeException("Falha no cadastro da senha");
		}
	}

}
