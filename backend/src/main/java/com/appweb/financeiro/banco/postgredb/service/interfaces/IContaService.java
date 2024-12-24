package com.appweb.financeiro.banco.postgredb.service.interfaces;

import org.springframework.stereotype.Service;

import com.appweb.financeiro.banco.postgredb.dto.output.ContaDTO;
import com.appweb.financeiro.banco.postgredb.entity.Conta;

@Service
public interface IContaService {

	public ContaDTO findContaByClienteId(String id);

	public Conta save(Conta conta);
	
	public ContaDTO getConta(String id);
	
	public Conta findContaById(String id);
	
	public void updateConta(Conta conta);

}
