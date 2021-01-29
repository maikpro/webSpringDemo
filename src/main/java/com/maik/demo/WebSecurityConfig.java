package com.maik.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


//Quelle: https://spring.io/guides/gs/securing-web/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/*The configure(HttpSecurity) method defines which URL paths should be secured 
	 * and which should not. Specifically, the / and /home paths are configured to not require any authentication. 
	 * All other paths must be authenticated.*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
							//.antMatchers("/", "/home").permitAll()
							.anyRequest().authenticated()
							.and()
				.formLogin()
							.loginPage("/login")
							.permitAll()
							.and()
				//logout gibt es noch nicht
				.logout()
							.permitAll();
	}
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		//UserDetails userDetails = User.withUsername("maik");
		UserDetails userdata =
				User.withDefaultPasswordEncoder()
						.username("maik")
						.password("maik")
						.roles("USER")
						.build();
		return new InMemoryUserDetailsManager(userdata);
	}
}
