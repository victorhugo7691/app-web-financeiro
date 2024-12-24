package com.appweb.financeiro.banco.postgredb.dto.output;

import com.appweb.financeiro.banco.postgredb.entity.Conta;

public record ContaDTO(
		String id,
		Integer numeroDaConta, 
		String situacao, 
		Float saldo, 
		String clienteId) {
	public ContaDTO(Conta conta) {
		this(conta.getId().toString(), conta.getNumeroDaConta(), conta.getSituacao().getDescricao(), conta.getSaldo(), conta.getCliente().getId().toString());
	}
}
