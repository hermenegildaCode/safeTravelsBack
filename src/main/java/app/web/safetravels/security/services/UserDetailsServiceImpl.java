package app.web.safetravels.security.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import app.web.safetravels.entity.Usr;
import app.web.safetravels.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			Usr usr = userRepository.findByUsername(username);
			UserBuilder builder = null;
			if(usr!=null) {
				builder = User.withUsername(username);
				builder.disabled(false);
				builder.password(usr.getPasswd());
				builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
			}else {
				throw new UsernameNotFoundException(username);
			}
			return builder.build();
	}
	

	
}
