package com.example.bookmanagementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. H2 콘솔은 Frame 구조를 사용하므로 X-Frame-Options를 SAMEORIGIN으로 설정
                .headers(headers -> headers
                        .frameOptions(frame -> frame.sameOrigin())
                )
                // 2. CSRF 보호에서 H2 콘솔 경로 제외 (로그인 시 필요)
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")
                )
                // 3. H2 콘솔 경로에 대한 접근 허용
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}