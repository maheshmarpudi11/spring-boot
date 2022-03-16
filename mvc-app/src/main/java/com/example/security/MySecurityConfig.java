package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	  @Autowired public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
		  auth.inMemoryAuthentication()
		  	.withUser("admin").password("{noop}password").roles("ADMIN") .and()
		  	.withUser("user").password("{noop}password").roles("USER"); 
	  }
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
				.antMatchers("/h2-console/**,/actuator/**").permitAll()
				.antMatchers("/app/*").authenticated()
				.and()
			.formLogin()
				.loginPage("/")
				.permitAll()
				.and()
			.logout().logoutUrl("/logout")
				.permitAll();
		
		http.headers().frameOptions().disable();
	
	}

	
}