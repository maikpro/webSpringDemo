package com.ooad.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//Quelle: https://spring.io/guides/gs/securing-web/

/** WebSecurityConfig
 * @author Marcel Sauer (Hauptverantwortlich), Maik Proba,  Hafiyyan Teh
 * @version 1.0
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired PasswordEncoder passwordEncoder;
	
	/**
	 * Die Konfiguration für die Authentifizierung der jeweiligen Accounts werden hier vorgenommen.
	 * @param auth mit Hilfe des AuthenticationManagerBuilders werden die drei Accounts ("admin", "seller" und "support") mit ihren jeweiligen Rollen erstellt .
	 */
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
	
	/**
	 * @return als PasswortEncoder wird BCryptPasswordEncoder verwendet. Zum Verschlüsseln des Passworts.
	 */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	/*The configure(HttpSecurity) method defines which URL paths should be secured 
	 * and which should not. Specifically, the / and /home paths are configured to not require any authentication. 
	 * All other paths must be authenticated.*/
    /**
     * Hierbei werden die Rechte der Accounts konfiguriert. Es ist nur Authorisierten Clients möglich die Webseite aufzurufen.
     * Der Account Seller darf z.B. nur Artikel einstellen.
     * @param http bei jedem HTTP-Request wird der Client überprüft
     * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.cors()		//
				.and()		//
				.csrf()		//
				.disable() // Dieser Part wird für den http POST ausgeschaltet! -> Nur für die DEMO sinnvoll zum Testen.
				
				.authorizeRequests()
							.antMatchers("/artikelEinstellen")
							.access("hasRole('SELLER')")
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
}
