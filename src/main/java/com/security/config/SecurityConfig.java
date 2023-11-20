package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http)throws Exception {
		http.csrf(csrf->csrf.disable())
		     .authorizeHttpRequests(auth->auth
		     .requestMatchers("/patient/**").hasRole("Admin").anyRequest().authenticated()
		     .requestMatchers("/patient/get/{id}").hasRole("USER").anyRequest().authenticated())
		     .formLogin(formLogin->formLogin.permitAll());
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		UserDetails user = User.withUsername("Rocky").password(encoder.encode("rocky")).roles("USER").build();
		UserDetails admin = User.withUsername("Admin").password(encoder.encode("admin")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user,admin);
	}
}
