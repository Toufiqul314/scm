package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.scm.services.impl.SecurityCustomUserDetailService;

@Configuration
public class SecurityConfig {

    // user create and login using java code with in memory service
    /*  //user config password
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
        //config end 
     */
    @Autowired
    private SecurityCustomUserDetailService userDetailService;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        //user detail service object creating the authentication
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        //password encoder object creating the password encryption
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
