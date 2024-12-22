package com.appweb.financeiro.banco.postgredb.service;

import org.springframework.stereotype.Service;

import com.appweb.financeiro.banco.postgredb.dto.output.ContaDTO;

@Service
public interface IContaService {
	
	public ContaDTO findContaByClienteId(Integer id);

}
