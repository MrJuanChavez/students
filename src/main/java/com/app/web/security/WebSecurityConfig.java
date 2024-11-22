package com.app.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import static org.springframework.security.config.Customizer.withDefaults;
import com.app.web.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	private final UserService userService;
	private final BCryptPasswordEncoder passwordEncoder;
	
	public WebSecurityConfig(UserService userService, BCryptPasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder);
		return auth;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/admin/**").hasRole("ADMIN");
			auth.requestMatchers("/",
					"/login",
					"/registry")
//					"/oauth2/**",
//					"/oauth2/callback")
			.permitAll();
			auth.anyRequest().authenticated();
		})
		.formLogin(form -> form
				.loginPage("/login")
				.permitAll())
//		.oauth2Login(oauth -> oauth
//			.loginPage("/login")
//			.defaultSuccessUrl("/index", true)
//			.failureUrl("/login?error")
//		)
		.logout(logout -> logout
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll());
		return http
				.build();
	}
}
