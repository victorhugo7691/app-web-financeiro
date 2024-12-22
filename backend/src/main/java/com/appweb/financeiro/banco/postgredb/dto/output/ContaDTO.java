package com.appweb.financeiro.banco.postgredb.dto.output;

public record ContaDTO(
		Integer numeroDaConta, 
		String situacao, 
		Float saldo, 
		String clienteId) {
}
