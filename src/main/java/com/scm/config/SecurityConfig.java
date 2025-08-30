package com.scm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.var;

@Configuration
public class SecurityConfig {

    // user create and login using java code with in memory services
    @Bean
    public UserDetailsService UserDetailsService() {

        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("admin123")
                .password("123")
                .roles("ADMIN", "USER")
                .build();
        var userDetailsService = new InMemoryUserDetailsManager(user1);
        return userDetailsService;
    }
}
