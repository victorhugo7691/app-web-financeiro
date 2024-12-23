package com.appweb.financeiro.banco.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Desativa CSRF (não recomendado para produção)
				.authorizeHttpRequests(auth -> auth.requestMatchers("/login", "/cadastro").permitAll() // Endpoints
																										// públicos
						.anyRequest().authenticated() // Exige autenticação para outros endpoints
				).httpBasic(httpBasic -> {
				}); // Habilita autenticação básica sem configuração adicional

		return http.build();
	}
}
