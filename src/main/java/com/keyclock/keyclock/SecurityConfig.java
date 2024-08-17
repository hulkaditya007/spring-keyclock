package com.keyclock.keyclock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	   @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests(authorizeRequests ->
	                authorizeRequests
	                    .requestMatchers("/public").permitAll()  // Public endpoint
	                    .anyRequest().authenticated()           // Secured endpoints
	            )
	            .oauth2ResourceServer(oauth2ResourceServer ->
	                oauth2ResourceServer
	                    .jwt()  // Enable JWT authentication
	            );

	        return http.build();
	    }

	    @Bean
	    public JwtDecoder jwtDecoder() {
	        // Replace the issuer URI with your Keycloak realm's issuer URI
	        String issuerUri = "http://localhost:8080/realms/react-realm";
	        return NimbusJwtDecoder.withIssuerLocation(issuerUri).build();
	    }

}
