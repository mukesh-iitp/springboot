package com.ticketbooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
//WebSecurityConfigureAdapter is still in use as next interface still in development
@EnableWebSecurity
//This annotation will load SecurityConfig as default Security Filter
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//Populating the Authentication Data to Authentication Object
	
	@Autowired
	private void configure_global(AuthenticationManagerBuilder authObj) throws Exception{
		
		//Creating user1 => nareshitadmin / narehsitadmin => admin
		authObj.inMemoryAuthentication().withUser("nareshitadmin").password("{noop}nareshitadmin").roles("ADMIN");
		//We cannot inject the plain text password in spring boot.
		//With noop keyword spring boot will automatically encrypt the password
		//Or we can also use the encryption methodology otherwise. 
		
		
		//Creating user2 => nareshitguest / narehsitguest => guest
		authObj.inMemoryAuthentication().withUser("nareshitguest").password("{noop}nareshitguest").roles("GUEST");
		
	}
	
	//Populating Authorization Rules
	@Override
	public void configure(HttpSecurity authorizationObj) throws Exception{
		
		//Authorization Rule1 => Admin role can access all tickets method.
		authorizationObj.csrf().disable()	//In next class
		.authorizeRequests().antMatchers("/tickets/all/**").hasAnyRole("ADMIN")
		//.and().formLogin();
		.and().httpBasic();
		//formLogin => This will render login page.
		//Authorization as HeaderName
		//Value should be Basic + " " + "Encrypted username and password in Base64"
		
		
		//Authorization Rule2 => Individual Ticket can be accessed by both ADMIN and GUEST.
		/*authorizationObj.csrf().disable()
		.authorizeRequests().antMatchers("/tickets/ticket/**").hasAnyRole("ADMIN","GUEST")
		.and().formLogin();
		*/
		
		authorizationObj.csrf().disable()
		.authorizeRequests().antMatchers("/tickets/ticket/**").hasAnyRole("ADMIN","GUEST")
		.and().httpBasic();
		
		//formLogin will render the login jsp page
		//httpBasic will render a login popup given by security.
		
	}
}
