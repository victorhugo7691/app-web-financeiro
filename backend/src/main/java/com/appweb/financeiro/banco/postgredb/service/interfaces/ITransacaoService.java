package com.appweb.financeiro.banco.postgredb.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appweb.financeiro.banco.postgredb.dto.output.TransacaoDTO;

@Service
public interface ITransacaoService {

	public List<TransacaoDTO> findTransacoesByContaId(String id);

	public List<TransacaoDTO> findMiniTransacoesByContaId(String id);

	public String creditar(String id, Float valor);

	public String debitar(String id, Float valor);
}
