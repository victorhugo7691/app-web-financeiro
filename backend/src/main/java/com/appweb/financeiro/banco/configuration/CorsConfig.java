package com.appweb.financeiro.banco.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//@Configuration
public class CorsConfig {

   /* @Bean
    CorsFilter corsFilter() {
        // Criando a configuração de CORS
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList(
                "http://127.0.0.1:4200",  // Frontend em desenvolvimento
                "https://app-web-financeiro.onrender.com" // Frontend em produção
        ));
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedHeader("*");  // Permite qualquer header

        // Criando o source de CORS e registrando a configuração
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        // Retornando o CorsFilter com a configuração
        return new CorsFilter(source); // Usa CorsConfigurationSource corretamente
    }*/
}