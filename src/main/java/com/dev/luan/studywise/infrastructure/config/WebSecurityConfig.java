package com.dev.luan.studywise.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    @Value("${keycloak.resource}")
    private String resourceName;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
                .oauth2ResourceServer(
                        oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())))
                .authorizeHttpRequests(auth -> {
                    auth.anyRequest().authenticated();
                });

        return http.build();
    }

    /**
     * Cria e configura um JwtAuthenticationConverter para integrar o processamento
     * de JWTs do Spring Security com as roles definidas no Keycloak.
     * Este conversor:
     * - Procura o claim "realm_access.roles" dentro do token JWT emitido pelo
     * Keycloak.
     * - Adiciona o prefixo "ROLE_" a cada role encontrada, seguindo a convenção do
     * Spring Security.
     * - Retorna um JwtAuthenticationConverter que injeta essas authorities no
     * contexto de segurança.
     *
     * @return um JwtAuthenticationConverter configurado para extrair roles de um
     *         JWT do Keycloak
     */
    private JwtAuthenticationConverter jwtAuthenticationConverter() {

        JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(new KeycloakAuthoritiesConverter(resourceName));

        return jwtConverter;
    }

}
