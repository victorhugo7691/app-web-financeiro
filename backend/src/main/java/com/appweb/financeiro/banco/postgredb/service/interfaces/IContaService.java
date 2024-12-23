package com.appweb.financeiro.banco.postgredb.service.interfaces;

import org.springframework.stereotype.Service;

import com.appweb.financeiro.banco.postgredb.dto.output.ContaDTO;
import com.appweb.financeiro.banco.postgredb.entity.Conta;

@Service
public interface IContaService {

	public ContaDTO findContaByClienteId(Integer id);

	public Conta save(Conta conta);

}
