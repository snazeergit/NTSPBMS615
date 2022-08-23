package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource ds;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Using Database as authentication info provider through Spring JDBC
		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
				.usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?")//For authentication
				.authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USERS_ROLES WHERE UNAME=?");//for authorization
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		//Authorize requests
		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/offers").authenticated()
				.antMatchers("/balance").hasAnyRole("CUSTOMER", "MANAGER")
				.antMatchers("/loan").hasRole("MANAGER")
				.anyRequest().authenticated() 
				//To enable form based authentication
				.and().formLogin()
				//Enables remember me option in form based authentication
				.and().rememberMe()
				//to logout from the existing active session
				//.and().logout() // if we use the default handler 'logout' in jsp
				.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))

		//configure custom error page for 403 error 
		.and().exceptionHandling().accessDeniedPage("/denied")
		
		//session max concurrency control
		.and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
	}

}
