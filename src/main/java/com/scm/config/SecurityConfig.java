package com.scm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    // user create and login using java code with in memory service
    @Bean
    public UserDetailsService userDetailsService() {
        //creating the user
        UserDetails user1 = User
                .withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN", "USER")
                .build();

        UserDetails user2 = User
                .withDefaultPasswordEncoder()
                .username("root")
                .password("root")
                .build();

        //creating object
        var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1, user2);

        return inMemoryUserDetailsManager;
    }
}
