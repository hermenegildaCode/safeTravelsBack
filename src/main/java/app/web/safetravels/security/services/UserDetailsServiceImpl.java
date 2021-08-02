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
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usr user = userRepository.findByUsername(email)
				.orElseThrow(() -> new UsernameNotFoundException("User with email: " + email + "not found"));

		return UserDetailsImpl.build(user);
	}
}
