package com.appweb.financeiro.banco.postgredb.dto.output;

import com.appweb.financeiro.banco.postgredb.entity.Transacao;

public record TransacaoDTO(
		String id, 
		String dataEHora, 
		Float valor, 
		String tipo, 
		String contaId) {
	public TransacaoDTO(Transacao transacao) {
		this(transacao.getId().toString(), transacao.getDataEHora().toString(), transacao.getValor(),
				transacao.getTipo().getDescricao(), transacao.getConta().getId().toString());
	}
}
