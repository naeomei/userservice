package com.vazquez.capstone.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/users/register", "/users/login").permitAll() 
                .requestMatchers("/users/{username}").permitAll() 
                .requestMatchers("/users/").permitAll()

                .anyRequest().authenticated() 
            )


            .formLogin(formLogin -> formLogin
                .disable() 
            )
            .logout(logout -> logout
                .permitAll() 
            )
            .csrf(csrf -> csrf.disable()); 

        return http.build();
    }
}
