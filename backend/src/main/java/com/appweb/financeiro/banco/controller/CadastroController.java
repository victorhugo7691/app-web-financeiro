package com.appweb.financeiro.banco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appweb.financeiro.banco.postgredb.dto.input.CadastroFormDTO;
import com.appweb.financeiro.banco.postgredb.service.interfaces.ICadastroService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/cadastro")
public class CadastroController {

	private ICadastroService cadastroService;

	public CadastroController(ICadastroService cadastroService) {
		this.cadastroService = cadastroService;
	}

	@PostMapping
	public ResponseEntity<Void> cadastrarCliente(@RequestBody @Valid CadastroFormDTO form) {
		this.cadastroService.cadastrarCliente(form);
		return ResponseEntity.ok().build();
	}
}
