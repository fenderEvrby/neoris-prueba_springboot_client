package com.neoris.client_app.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authHttp) -> authHttp
                .requestMatchers(HttpMethod.GET, "/authorized", "/api/pokemon/{nombre}", "/api/encriptar/{texto}").permitAll()
                .requestMatchers(HttpMethod.GET, "/list", "/api/items", "/api/items/{nombre}").hasAnyAuthority("SCOPE_read", "SCOPE_write")
                .requestMatchers(HttpMethod.POST, "/create", "/api/items").hasAnyAuthority("SCOPE_write")
                .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2Login(login -> login.loginPage("/oauth2/authorization/client-app"))
                .oauth2Client(withDefaults())
                .oauth2ResourceServer(resourceServer -> resourceServer.jwt(withDefaults()));
        return http.build();
    }
}