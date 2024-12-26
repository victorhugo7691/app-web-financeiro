package com.appweb.financeiro.banco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appweb.financeiro.banco.postgredb.dto.input.LoginInputDTO;
import com.appweb.financeiro.banco.postgredb.dto.output.ContaDTO;
import com.appweb.financeiro.banco.postgredb.service.interfaces.ILoginService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "https://app-web-financeiro-frontend.onrender.com")
@RestController
@RequestMapping("/login")
public class LoginController {

	private ILoginService loginService;

	public LoginController(ILoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping
	public ResponseEntity<ContaDTO> realizarLogin(@RequestBody @Valid LoginInputDTO login) {
		ContaDTO conta = this.loginService.realizarLogin(login);

		if (conta == null) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}

		return ResponseEntity.ok(conta);
	}
}
