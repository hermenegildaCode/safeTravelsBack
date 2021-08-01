package app.web.safetravels.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import app.web.safetravels.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		auth.inMemoryAuthentication().withUser("admin").password("abc123..").roles("USER");
		super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/auth/**", "/public/**", "/hotels/**", "/hotel/**", "/css/**", "/js/**" ).permitAll().anyRequest().authenticated()
		.and().formLogin().loginPage("/auth/login").defaultSuccessUrl("/private/mybookings", true).failureUrl("/auth/login?error=true")
		.loginProcessingUrl("/auth/login-post").permitAll()
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/pubic/index");
	}
	
}
