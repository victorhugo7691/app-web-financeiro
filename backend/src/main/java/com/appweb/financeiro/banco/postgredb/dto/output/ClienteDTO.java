package com.appweb.financeiro.banco.postgredb.dto.output;

public record ClienteDTO(
		String id,
		String nome,
		Integer idade,
		String email) {
}
