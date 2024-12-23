package com.appweb.financeiro.banco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appweb.financeiro.banco.postgredb.dto.output.ClienteDTO;
import com.appweb.financeiro.banco.postgredb.dto.output.ContaDTO;
import com.appweb.financeiro.banco.postgredb.service.interfaces.IClienteService;
import com.appweb.financeiro.banco.postgredb.service.interfaces.IContaService;

@CrossOrigin
@RestController
@RequestMapping("/home")
public class HomeController {

	private IContaService contaService;

	private IClienteService clienteService;

	public HomeController(IContaService contaService, IClienteService clienteService) {
		this.contaService = contaService;
		this.clienteService = clienteService;
	}

	@GetMapping("/conta")
	public ResponseEntity<ContaDTO> findContaByClienteId(@PathVariable Integer id) {
		ContaDTO conta = this.contaService.findContaByClienteId(id);

		if (conta == null) {
			ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(conta);
	}

	@GetMapping("/cliente/{id}")
	public ResponseEntity<ClienteDTO> findClienteById(@PathVariable Integer id) {
		ClienteDTO cliente = this.clienteService.findClienteById(id);

		if (cliente == null) {
			ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(cliente);
	}
	
}
