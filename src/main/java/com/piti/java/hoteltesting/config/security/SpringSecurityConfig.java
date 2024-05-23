package com.piti.java.hoteltesting.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.piti.java.hoteltesting.config.security.jwt.JwtAuthenticationEntryPoint;
import com.piti.java.hoteltesting.config.security.jwt.JwtAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurityConfig {
	
	@SuppressWarnings("unused")
	private UserDetailsService userDetailsService;
	   
	private JwtAuthenticationEntryPoint authenticationEntryPoint;

	private JwtAuthenticationFilter authenticationFilter;
	 
	 @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
	 
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	//http.csrf().disable()
    	http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorize) -> {

                	 authorize.requestMatchers("/",
                  		   "index.html",
                		   "home",
                  		   "/swagger-resources/*",                   
                  		   "/swagger-ui/**",
                		   "/bus/v3/api-docs/**",
                		   "/swagger-ui.html").permitAll();
                	 authorize.requestMatchers("/api/v1/auth/**","/api/v1/hotel").permitAll();
                     authorize.requestMatchers(HttpMethod.OPTIONS).permitAll();
                    authorize.anyRequest().authenticated();
                }).httpBasic(Customizer.withDefaults());
    	
    	http.exceptionHandling( exception -> exception
                .authenticationEntryPoint(authenticationEntryPoint));
    	
    	http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
    	
        return http.build();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
