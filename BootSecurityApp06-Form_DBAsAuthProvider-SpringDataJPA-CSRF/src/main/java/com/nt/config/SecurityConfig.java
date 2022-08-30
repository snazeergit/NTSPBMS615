package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService service;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(encoder);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//To feel the CSRF run this application and keep it in running mode and also run the CSRF_Test application below also and click on Show Balance
		//Cross Site Requesting Forgery
		http//.csrf().disable() //disabling CSRF , by default it will be enabled
		        .authorizeRequests().antMatchers("/bank/","/user/register", "/user/showLogin").permitAll()
				.antMatchers("/bank/offers").authenticated()
				.antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER", "MANAGER")
				.antMatchers("/bank/loan").hasAuthority("MANAGER")
				.anyRequest().authenticated()
				//shows home page on successful login                       
				.and().formLogin().defaultSuccessUrl("/bank/",true)
				//for GET mode request to show the custom login page
				.loginPage("/user/showLogin")
				//for POST mode request to submit and process the request
				.loginProcessingUrl("/login")
				//Authentication failed url
				.failureUrl("/user/showLogin?error")
				.and().rememberMe()
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/bank/signout"))
				//after logout url
				.logoutSuccessUrl("/user/showLogin?logout")
				.and().exceptionHandling().accessDeniedPage("/bank/denied")
				.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}

}
