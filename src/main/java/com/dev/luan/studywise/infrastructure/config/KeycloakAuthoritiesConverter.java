package com.dev.luan.studywise.infrastructure.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

public class KeycloakAuthoritiesConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    // Nome do client no keycloak
    private final String resourceName;

    public KeycloakAuthoritiesConverter(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    @SuppressWarnings({ "unchecked", "null" })
    public Collection<GrantedAuthority> convert(Jwt jwt) {

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        // Realm Roles (ROLE_ADMIN, ROLE_USER)
        JwtGrantedAuthoritiesConverter realmConverter = new JwtGrantedAuthoritiesConverter();
        realmConverter.setAuthoritiesClaimName("realm_access"); // Acessa a claim realm_access
        realmConverter.setAuthorityPrefix("ROLE_");

        // Extrai roles de realm_access.roles
        if (jwt.hasClaim("realm_access")) {
            Map<String, Object> realmAccess = jwt.getClaim("realm_access");
            if (realmAccess.containsKey("roles")) {
                List<String> realmRoles = (List<String>) realmAccess.get("roles");
                realmRoles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role)));
            }
        }

        // Client Roles (subjects:create, etc)
        if (jwt.hasClaim("resource_access")) {
            Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
            if (resourceAccess.containsKey(resourceName)) { // Nome do client no Keycloak
                Map<String, Object> client = (Map<String, Object>) resourceAccess.get(resourceName);
                if (client.containsKey("roles")) {
                    List<String> clientRoles = (List<String>) client.get("roles");
                    clientRoles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
                }
            }
        }

        System.out.println("Authorities: " + authorities);
        return authorities;
    }
}