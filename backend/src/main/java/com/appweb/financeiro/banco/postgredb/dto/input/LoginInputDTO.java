package com.appweb.financeiro.banco.postgredb.dto.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginInputDTO(@NotNull(message = "Informe o numero da conta") Integer numeroDaConta,
		@NotBlank(message = "Informe a senha de acesso") String senha) {

}
