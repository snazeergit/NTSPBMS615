package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService service;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(service);
		authProvider.setPasswordEncoder(encoder);
		return authProvider;
	}

	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/bank/", "/user/register", "/user/showLogin").permitAll()
				.antMatchers("/bank/offers").authenticated().antMatchers("/bank/balance")
				.hasAnyAuthority("CUSTOMER", "MANAGER").antMatchers("/bank/loan").hasAuthority("MANAGER").anyRequest()
				.authenticated()
				
				//shows home page on successful login                       
				.and().formLogin().defaultSuccessUrl("/bank/", true)
				
				//for GET mode request to show the custom login page
				.loginPage("/user/showLogin")
				
				//for POST mode request to submit and process the request
				.loginProcessingUrl("/login")
				
				//Authentication failed url
				.failureUrl("/user/showLogin?error")
				
				//enables remember me option in form based authentication
				.and().rememberMe()
				
				//enable logout with custom url
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/bank/signout"))
				
				//after logout url
				.logoutSuccessUrl("/user/showLogin?logout")
				
				//configure custom error page for 403 error
				.and().exceptionHandling().accessDeniedPage("/bank/denied")
				
				//Session max concurrency control
				.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		
		//specify AuthenticationProvidr
		http.authenticationProvider(authenticationProvider());
		return http.build();
	}

}
