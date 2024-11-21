package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
    

    // configration of authentication provider spring security
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        //user detail service object creating the authentication
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        //password encoder object creating the password encryption
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    // url mapping

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        // configuration
        //urls configuration public  or private access
        httpSecurity.authorizeHttpRequests(authorize->{
            //authorize.requestMatchers("/home","/about","/register").permitAll();
            // ./user/any url protected access
            authorize.requestMatchers("/user/**").authenticated();
            // othe url protected
            authorize.anyRequest().permitAll();
        });
        // form login default login page spring security
        //something like change form login related permissions
        // httpSecurity.formLogin(Customizer.withDefaults());

        // user form login page spring security
        httpSecurity.formLogin(formLogin->{

            // user create login page url passing
            formLogin.loginPage("/login");
            formLogin.loginProcessingUrl("/authenticate");
            formLogin.successForwardUrl("/user/dashboard");
            // formLogin.failureForwardUrl("/login?error=true");
            formLogin.usernameParameter("email");
            formLogin.passwordParameter("password");

            /*
             //login form success and failure handler
            // failure handlers
            formLogin.failureHandler(new AuthenticationFailureHandler() {
                @Override
                public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
                
            });

            //success handler
            formLogin.successHandler(new AuthenticationSuccessHandler() {
                @Override
                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                    throw new UnsupportedOperationException("Not supported yet.");
                }
                
            });
            */
        });

        //logout the userFrom
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.logout(logoutForm->{
            logoutForm.logoutUrl("/logout");
            logoutForm.logoutSuccessUrl("/login?logout=true");
        });

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
