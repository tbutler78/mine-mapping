package com.tbutler78.minemapping.config.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
protected void configure(HttpSecurity http) throws Exception {

	http
			.formLogin()
			.defaultSuccessUrl("/home/index.html", true)
			.and()
			.authorizeRequests()
			.antMatchers("/book-service/**", "/rating-service/**", "/login*", "/")
			.permitAll()
			.antMatchers("/eureka/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.logout()
			.and()
			.csrf().disable();
}}