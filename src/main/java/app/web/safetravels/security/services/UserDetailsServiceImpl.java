package app.web.safetravels.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.web.safetravels.entity.Usr;
import app.web.safetravels.repository.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usr user = null;
				try {
					user = userRepository.findByUsername(username);
				} catch (Exception e) {
					new UsernameNotFoundException("User Not Found with username: " + username);	
				}

		return UserDetailsImpl.build(user);
	}
	@Transactional
	public UserDetails loadUserByEmail(String email) throws EmailNotFoundException {
		Usr user = null;
	try {
		user = userRepository.findByEmail(email);
	} catch (Exception e) {
		new EmailNotFoundException("User with email: " + email + "not found");
	}
		
		return UserDetailsImpl.build(user);
	}
}
