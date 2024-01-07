package com.jp.web.Service;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 認証に関する設定
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class defense {

    private final String[] ONLY_ADMIN_REQUESTS = new String[] { "/signup", "/contact/add",
            "/contact/create", "/contact/{id}/delete", "/contact/{id}/edit", "/contact/update",
            "/category/list", "/category/add"};

    /**
     * staticリソースは認証なしで見ることができる<br>
     * loginページ以外は認証が必要になる。<br>
     * ログインに成功した場合、indexに飛ぶ。<br>
     * logoutページも認証なしで見ることができる。
     *
     * @param http HttpSecurity
     * @return SecurityFilterChain
     * @throws Exception
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/login").permitAll().requestMatchers(ONLY_ADMIN_REQUESTS)
                        .hasRole("ADMIN").anyRequest().authenticated())
                .formLogin((form) -> form.loginPage("/login").defaultSuccessUrl("/").permitAll())
                .logout((logout) -> logout.logoutSuccessUrl("/login"));

        return http.build();
    }
}

