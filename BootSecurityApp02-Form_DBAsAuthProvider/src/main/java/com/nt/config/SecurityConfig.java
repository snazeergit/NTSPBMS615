package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		//Creates InMemory DB and uses it as a Authentication Provider
		auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("ramesh").password("{noop}hyd").roles("MANAGER");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//Authorize requests
		http.authorizeRequests().antMatchers("/").permitAll()//No authentication and no authorization
		.antMatchers("/offers").authenticated()//only authentication
				.antMatchers("/balance").hasAnyRole("CUSTOMER", "MANAGER")//authentication+authorization for CUSTOMER and MANAGER role uses
				.antMatchers("/loan").hasRole("MANAGER")//authentication+authorization
				.anyRequest().authenticated() //remaining all request URLs must be authenticated
				//To enable form based authentication
				.and().formLogin()
				//Enables remember me option in form based authentication
				.and().rememberMe()
				//to logout from the existing active session
				//.and().logout() // if we use the default handler logout in jsp
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
				//session max concurrency control
				.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		
		//configure custom error page for 403 error (works only when remember me option is not used)
		//.and().exceptionHandling().accessDeniedPage("/denied");
				
	}

}
