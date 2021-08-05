package app.web.safetravels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.web.safetravels.entity.Usr;
import app.web.safetravels.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public Usr saveUser(Usr usr) {
		return userRepository.save(usr);
	}
	public List<Usr> getAllUsers(){
		return userRepository.findAll();
	}
	public Usr getUserByEmail(String email) {
		return userRepository.findById(email).orElse(null);
	}
//	public List<Usr> getUsersByCountry(String country) {
//		return userRepository.findByCountry(country);
//	}
	
	public String deleteUser(String email) {
		userRepository.deleteById(email);
		return "usuario elimando: " + email;
	}
	public Usr updateUser (Usr usr){
		Usr existingUser= userRepository.findById(usr.getEmail()).orElse(null);
		existingUser.setUsername(usr.getUsername());
//		existingUser.setLastname(usr.getLastname());
//		existingUser.setCountry(usr.getCountry());
		existingUser.setPasswd(usr.getPasswd());
		return userRepository.save(existingUser);
	}
}