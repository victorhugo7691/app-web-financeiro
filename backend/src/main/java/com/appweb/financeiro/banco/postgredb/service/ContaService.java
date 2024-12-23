package com.appweb.financeiro.banco.postgredb.service;

import org.springframework.stereotype.Service;

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
	public ContaDTO findContaByClienteId(Integer id) {
		Conta contaRegistrada = this.contaRepository.findContaByClienteId(id);

		return new ContaDTO(contaRegistrada.getNumeroDaConta(), contaRegistrada.getSituacao().getDescricao(),
				contaRegistrada.getSaldo(), contaRegistrada.getCliente().getId().toString());
	}

	@Override
	public Conta save(Conta conta) {
		return this.contaRepository.save(conta);
	}

}