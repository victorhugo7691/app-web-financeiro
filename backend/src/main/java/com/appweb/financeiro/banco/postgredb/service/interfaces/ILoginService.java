package com.appweb.financeiro.banco.postgredb.service.interfaces;

import org.springframework.stereotype.Service;

import com.appweb.financeiro.banco.postgredb.dto.input.LoginInputDTO;
import com.appweb.financeiro.banco.postgredb.dto.output.ContaDTO;

@Service
public interface ILoginService {

	public ContaDTO realizarLogin(LoginInputDTO login);

}
