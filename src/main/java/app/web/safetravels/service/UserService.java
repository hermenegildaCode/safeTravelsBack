package app.web.safetravels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import app.web.safetravels.entity.Usr;
import app.web.safetravels.repository.UserRepository;
import app.web.safetravels.security.services.IUserService;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwdEncoder;

	public Usr saveUser(Usr usr) {
		return userRepository.save(usr);
	}
	public List<Usr> getAllUsers(){
		return userRepository.findAll();
	}
	public Usr getUserByEmail(String email) {
		return userRepository.findById(email).orElse(null);
	}
	public List<Usr> getUsersByCountry(String country) {
		return userRepository.findByCountry(country);
	}
	
	public String deleteUser(String email) {
		userRepository.deleteById(email);
		return "usuario elimando: " + email;
	}
	public Usr updateUser (Usr usr){
		Usr existingUser= userRepository.findById(usr.getEmail()).orElse(null);
		existingUser.setFirstname(usr.getFirstname());
		existingUser.setLastname(usr.getLastname());
		existingUser.setCountry(usr.getCountry());
		existingUser.setPasswd(usr.getPasswd());
		return userRepository.save(existingUser);
	}
	@Override
	public List<Usr> findByCountry(String country) {
		return userRepository.findByCountry(country);
	}
	@Override
	public Usr findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	@Override
	public Boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	@Override
	public Usr findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	@Override
	public Usr signup(Usr u) {
		u.setPasswd(passwdEncoder.encode(u.getPasswd()));
		return userRepository.save(u);
	}
}