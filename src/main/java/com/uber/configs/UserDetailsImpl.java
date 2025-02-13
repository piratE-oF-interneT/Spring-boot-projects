package com.uber.configs;

import com.uber.exceptions.ResourceNotFoundException;
import com.uber.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserDetailsImpl {

    @Autowired
    private UserRepository userRepository;


    @Bean
    public AuthenticationManager getAuthManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean

    public PasswordEncoder getPassowrdEncoder(){

        return  new BCryptPasswordEncoder();
    }

    @Bean

    public UserDetailsService getUserDetailsService(){

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("user not found with this email.."));
            }
        };
    }



}
