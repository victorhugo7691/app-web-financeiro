package com.appweb.financeiro.banco.postgredb.service.interfaces;

import com.appweb.financeiro.banco.postgredb.dto.input.CadastroFormDTO;

public interface ICadastroService {
	
	public void cadastrarCliente(CadastroFormDTO form);

}
