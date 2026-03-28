package com.turankerimov.config;

import com.turankerimov.entity.User;
import com.turankerimov.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;

@Configuration
public class ApplicationConfig {

    @Autowired
    private UserRepository userRepository;


    @Bean
     public UserDetailsService userDetailsService() {
        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Optional<User> optional = userRepository.findByUsername(username);
                if (optional.isPresent()) {
                    return optional.get();
                } else {
                    throw new UsernameNotFoundException(username);
                }
            }


        };
    }

      @Bean
      public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration ) {
          return configuration.getAuthenticationManager();
      }


    @Bean
    public BCryptPasswordEncoder  bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

