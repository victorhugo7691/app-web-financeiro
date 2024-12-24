package com.appweb.financeiro.banco.postgredb.service.interfaces;

import org.springframework.stereotype.Service;

import com.appweb.financeiro.banco.postgredb.dto.output.ClienteDTO;
import com.appweb.financeiro.banco.postgredb.entity.Cliente;

@Service
public interface IClienteService {

	public ClienteDTO findClienteById(String id);

	public Cliente save(Cliente cliente);
}
