package com.appweb.financeiro.banco.postgredb.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.appweb.financeiro.banco.postgredb.dto.output.ClienteDTO;
import com.appweb.financeiro.banco.postgredb.entity.Cliente;
import com.appweb.financeiro.banco.postgredb.repository.interfaces.IClienteRepository;
import com.appweb.financeiro.banco.postgredb.service.interfaces.IClienteService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClienteService implements IClienteService{

	private IClienteRepository clienteRepository;

	public ClienteService(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public ClienteDTO findClienteById(Integer id) {
		Cliente cliente = this.clienteRepository.findById(UUID.fromString(id.toString())).orElse(null);

		return new ClienteDTO(cliente.getId().toString(), cliente.getNome(), cliente.getIdade(), cliente.getEmail());
	}

	@Override
	public Cliente save(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
}
