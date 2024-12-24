package com.appweb.financeiro.banco.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SecurityConfig {

	//@Bean
	//PasswordEncoder passwordEncoder() {
	//	return new BCryptPasswordEncoder();
	//}

	/*@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Desativa CSRF (não recomendado para produção)
				.cors(cors -> cors.configurationSource(this.corsConfigurationSource())) // Configuração de CORS
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/login", "/cadastro", "/home/conta", "/home", "/home/cliente").permitAll() // Endpoints
						// públicos
						.anyRequest().authenticated() // Exige autenticação para outros endpoints
				).httpBasic(httpBasic -> {
				}); // Habilita autenticação básica sem configuração adicional

		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://127.0.0.1:4200", // Frontend em desenvolvimento
				"https://app-web-financeiro.onrender.com" // Frontend em produção
		));
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}*/
}
