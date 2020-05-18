package com.makefriend.makefriend.config;

import com.makefriend.makefriend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	private UserDetailsService userService;

	public WebSecurityConfig(UserService userService) {
		this.userService = userService;
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests().antMatchers("/auth/**").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/api/**").permitAll()
				.antMatchers(HttpMethod.GET,"/api/**").permitAll()
				.antMatchers(HttpMethod.GET,"/h2/**").permitAll()
				.antMatchers(HttpMethod.POST,"/h2/**").permitAll()
				.antMatchers(HttpMethod.GET,"/**").permitAll()
				.antMatchers(HttpMethod.OPTIONS, "/h2/**").permitAll()
				.anyRequest().authenticated().and().httpBasic();*/


	}

	@Override
	public void configure(WebSecurity web) {
		// TokenAuthenticationFilter will ignore the following
		web.ignoring().antMatchers(HttpMethod.GET, "/h2/**");// Change this after implementing certificates
		web.ignoring().antMatchers(HttpMethod.GET, "/api/**");// Change this after implementing certificates
		web.ignoring().antMatchers(HttpMethod.POST, "/h2/**");// Change this after implementing certificates
		web.ignoring().antMatchers(HttpMethod.POST, "/api/**");// Change this after implementing certificates

	}

}
