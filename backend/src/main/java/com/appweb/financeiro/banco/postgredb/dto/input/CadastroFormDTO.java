package com.appweb.financeiro.banco.postgredb.dto.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CadastroFormDTO {

	@NotBlank(message = "O nome deve ser informado")
	private String nomeDoCliente;

	@NotNull(message = "A idade deve ser informada")
	private Integer idade;

	@Email
	private String email;

	@NotNull(message = ("Informe o numero da conta"))
	private Integer numeroDaConta;
	
	@NotBlank(message = "Informe a senha de acesso à conta")
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeDoCliente() {
		return nomeDoCliente;
	}

	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(Integer numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}
}
