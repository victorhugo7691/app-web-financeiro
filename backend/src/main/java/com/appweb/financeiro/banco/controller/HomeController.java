package com.appweb.financeiro.banco.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appweb.financeiro.banco.postgredb.dto.output.ContaDTO;
import com.appweb.financeiro.banco.postgredb.service.IContaService;

@RestController
@RequestMapping("/home")
public class HomeController {

	private IContaService contaService;

	public HomeController(IContaService contaService) {
		this.contaService = contaService;
	}

	@GetMapping("/conta")
	public ResponseEntity<ContaDTO> findContaByClienteId(@PathVariable Integer id){
		ContaDTO conta = this.contaService.findContaByClienteId(id);
		
		if(conta == null) {
			ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(conta);
	}
}
