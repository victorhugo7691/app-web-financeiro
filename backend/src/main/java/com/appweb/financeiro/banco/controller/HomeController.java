package com.appweb.financeiro.banco.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appweb.financeiro.banco.postgredb.dto.output.ClienteDTO;
import com.appweb.financeiro.banco.postgredb.dto.output.ContaDTO;
import com.appweb.financeiro.banco.postgredb.dto.output.TransacaoDTO;
import com.appweb.financeiro.banco.postgredb.service.interfaces.IClienteService;
import com.appweb.financeiro.banco.postgredb.service.interfaces.IContaService;
import com.appweb.financeiro.banco.postgredb.service.interfaces.ITransacaoService;

@CrossOrigin(origins = "https://app-web-financeiro-frontend.onrender.com")
@RestController
@RequestMapping("/home")
public class HomeController {

	private IContaService contaService;

	private IClienteService clienteService;

	private ITransacaoService transacaoService;

	public HomeController(IContaService contaService, IClienteService clienteService,
			ITransacaoService transacaoService) {
		this.contaService = contaService;
		this.clienteService = clienteService;
		this.transacaoService = transacaoService;
	}

	@GetMapping("/conta/{id}")
	public ResponseEntity<ContaDTO> findContaByClienteId(@PathVariable String id) {
		ContaDTO conta = this.contaService.findContaByClienteId(id);

		if (conta == null) {
			ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(conta);
	}

	@GetMapping("/cliente/{id}")
	public ResponseEntity<ClienteDTO> findClienteById(@PathVariable String id) {
		ClienteDTO cliente = this.clienteService.findClienteById(id);

		if (cliente == null) {
			ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(cliente);
	}

	@GetMapping("/mini-extrato/{id}")
	public ResponseEntity<List<TransacaoDTO>> findMiniTrasacoes(@PathVariable String id) {
		List<TransacaoDTO> transacoes = this.transacaoService.findMiniTransacoesByContaId(id);

		if (transacoes.isEmpty()) {
			ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(transacoes);
	}

	@PostMapping("/creditar/{id}")
	public ResponseEntity<String> creditar(@PathVariable String id, @RequestParam(required = true) Float valor) {
		String idTransacao = this.transacaoService.creditar(id, valor);

		if (idTransacao.isBlank()) {
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(idTransacao);
	}
	
	@PostMapping("/debitar/{id}")
	public ResponseEntity<String> debitar(@PathVariable String id, @RequestParam(required = true) Float valor) {
		String idTransacao = this.transacaoService.debitar(id, valor);

		if (idTransacao.isBlank()) {
			ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(idTransacao);
	}

}
