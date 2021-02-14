package com.ooad.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


//Quelle: https://spring.io/guides/gs/securing-web/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired PasswordEncoder passwordEncoder;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .passwordEncoder(passwordEncoder)
        .withUser("admin").password(passwordEncoder.encode("admin")).roles("ADMIN")
        .and()
        .withUser("seller").password(passwordEncoder.encode("seller")).roles("SELLER")
        .and()
        .withUser("support").password(passwordEncoder.encode("support")).roles("SUPPORT");
        //TODO DB einbinden(nicht statisch)
        //TODO DB account erweitern mit adresse
    }
 
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	/*The configure(HttpSecurity) method defines which URL paths should be secured 
	 * and which should not. Specifically, the / and /home paths are configured to not require any authentication. 
	 * All other paths must be authenticated.*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.cors()		//
				.and()		//
				.csrf()		//
				.disable() // Dieser Part wird für den http POST ausgeschaltet!
				
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
	
	
	
	/*@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		//UserDetails userDetails = User.withUsername("maik");
		UserDetails userdata =
				User.withDefaultPasswordEncoder()
						.username("admin")
						.password("admin")
						.roles("ADMIN")
						.build();
		return new InMemoryUserDetailsManager(userdata);
	}*/
	
	
}
