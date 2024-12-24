package com.appweb.financeiro.banco.postgredb.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.appweb.financeiro.banco.exceptions.FalhaNaAtividadeException;
import com.appweb.financeiro.banco.postgredb.dto.output.ContaDTO;
import com.appweb.financeiro.banco.postgredb.entity.Conta;
import com.appweb.financeiro.banco.postgredb.repository.interfaces.IContaRepository;
import com.appweb.financeiro.banco.postgredb.service.interfaces.IContaService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContaService implements IContaService {

	private IContaRepository contaRepository;

	public ContaService(IContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	@Override
	public ContaDTO findContaByClienteId(String id) {
		Conta contaRegistrada = this.contaRepository.findContaByClienteId(UUID.fromString(id));

		return new ContaDTO(contaRegistrada);
	}

	@Override
	public Conta save(Conta conta) {
		return this.contaRepository.save(conta);
	}

	@Override
	public ContaDTO getConta(String id) {
		return new ContaDTO(this.contaRepository.findById(UUID.fromString(id)).orElse(null));
	}

	@Override
	public Conta findContaById(String id) {
		return this.contaRepository.findById(UUID.fromString(id)).orElse(null);
	}

	@Override
	public void updateConta(Conta conta) {
		try {
			this.contaRepository.save(conta);
		} catch (FalhaNaAtividadeException exception) {
			throw new FalhaNaAtividadeException("Falhou ao salvar a conta");
		}
	}

}
