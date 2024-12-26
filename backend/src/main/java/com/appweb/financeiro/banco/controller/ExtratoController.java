package com.appweb.financeiro.banco.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appweb.financeiro.banco.postgredb.dto.output.ContaDTO;
import com.appweb.financeiro.banco.postgredb.dto.output.TransacaoDTO;
import com.appweb.financeiro.banco.postgredb.service.interfaces.IContaService;
import com.appweb.financeiro.banco.postgredb.service.interfaces.ITransacaoService;

@CrossOrigin(origins = "https://app-web-financeiro-frontend.onrender.com")
@RestController
@RequestMapping("/extrato")
public class ExtratoController {

	private ITransacaoService transacaoService;

	private IContaService contaService;

	public ExtratoController(ITransacaoService transacaoService, IContaService contaService) {
		this.transacaoService = transacaoService;
		this.contaService = contaService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<TransacaoDTO>> findTrasacoes(@PathVariable String id) {
		List<TransacaoDTO> transacoes = this.transacaoService.findTransacoesByContaId(id);

		if (transacoes == null) {
			ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(transacoes);
	}

	@GetMapping("/conta/{id}")
	public ResponseEntity<ContaDTO> findContaById(@PathVariable String id) {
		ContaDTO conta = this.contaService.getConta(id);

		if (conta == null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(conta);
	}
}
