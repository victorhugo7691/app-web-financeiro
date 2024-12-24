package com.appweb.financeiro.banco.postgredb.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.appweb.financeiro.banco.exceptions.DadosNaoEncontradosException;
import com.appweb.financeiro.banco.exceptions.FalhaNaAtividadeException;
import com.appweb.financeiro.banco.postgredb.dto.output.TransacaoDTO;
import com.appweb.financeiro.banco.postgredb.entity.Conta;
import com.appweb.financeiro.banco.postgredb.entity.Transacao;
import com.appweb.financeiro.banco.postgredb.enuns.ETipoDaTransacao;
import com.appweb.financeiro.banco.postgredb.repository.interfaces.ITransacaoRepository;
import com.appweb.financeiro.banco.postgredb.service.interfaces.IContaService;
import com.appweb.financeiro.banco.postgredb.service.interfaces.ITransacaoService;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class TransacaoService implements ITransacaoService {

	private ITransacaoRepository transacaoRepository;

	private IContaService contaService;

	public TransacaoService(ITransacaoRepository transacaoRepository, IContaService contaService) {
		this.transacaoRepository = transacaoRepository;
		this.contaService = contaService;
	}

	@Override
	public List<TransacaoDTO> findTransacoesByContaId(String id) {
		List<Transacao> transacoes = new ArrayList<>();
		try {
			transacoes = this.transacaoRepository.findTransacoesByContaId(UUID.fromString(id));
		} catch (DadosNaoEncontradosException exception) {
			throw new DadosNaoEncontradosException("Não há transações");
		}

		return transacoes.stream().map(transacao -> new TransacaoDTO(transacao)).toList();
	}

	@Override
	public List<TransacaoDTO> findMiniTransacoesByContaId(String id) {
		List<Transacao> transacoes = new ArrayList<>();
		try {
			transacoes = this.transacaoRepository.findMiniTransacoesByContaId(UUID.fromString(id));
		} catch (DadosNaoEncontradosException exception) {
			throw new DadosNaoEncontradosException("Não há transações");
		}

		return transacoes.stream().map(transacao -> new TransacaoDTO(transacao)).toList();
	}

	@Override
	public String creditar(String id, Float valor) {
		Conta conta = this.contaService.findContaById(id);

		Float saldo = conta.getSaldo();
		saldo = saldo + valor;
		conta.setSaldo(saldo);

		this.contaService.updateConta(conta);

		return this.transacao(conta, valor, ETipoDaTransacao.CREDITO).getId().toString();
	}

	@Override
	public String debitar(String id, Float valor) {
		Conta conta = this.contaService.findContaById(id);

		if (conta.getSaldo() < valor) {
			throw new FalhaNaAtividadeException("Saldo insuficiente");
		}

		Float saldo = conta.getSaldo();
		saldo = saldo - valor;
		conta.setSaldo(saldo);

		this.contaService.updateConta(conta);

		return this.transacao(conta, valor, ETipoDaTransacao.DEBITO).getId().toString();
	}

	private Transacao transacao(Conta conta, Float valor, ETipoDaTransacao tipo) {
		Transacao transacao = new Transacao();

		transacao.setConta(conta);
		transacao.setDataEHora(LocalDateTime.now());
		transacao.setTipo(tipo);
		transacao.setValor(valor);

		try {
			return this.transacaoRepository.save(transacao);
		} catch (FalhaNaAtividadeException exception) {
			throw new FalhaNaAtividadeException("Saldo insuficiente");
		}
	}

}
