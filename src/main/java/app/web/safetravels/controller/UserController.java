package app.web.safetravels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.web.safetravels.entity.Usr;
import app.web.safetravels.service.UserService;


@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/addUser")
	public Usr addUser(@RequestBody Usr usr) {
		return userService.saveUser(usr);
	}
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/users")
	public List<Usr> findAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/user/{email}")
	public Usr findUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}
	
	@GetMapping("/user/{username}")
	public Usr findUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

//	@GetMapping("/usersByCountry/{country}")
//	public List<Usr> findUsersByCountry(@PathVariable String country) {
//		return userService.getUsersByCountry(country);
//	}

	@PutMapping("/updateUser")
	public Usr updateUsr(@RequestBody Usr usr) {
		return userService.updateUser(usr);
	}

	@DeleteMapping("deleteUser/{email}")
	public String deleteUsr(@PathVariable String email) {
		return userService.deleteUser(email);
	}
}
