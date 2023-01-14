package app.web.safetravels;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200", "https://site--front--p6vkzqn94x74.code.run/", "https://safetravelss.herokuapp.com", "https://safetravelz.herokuapp.com", "https://safetravelz.herokuapp.com/web", "https://site--front--p6vkzqn94x74.code.run/"})
@RestController
@RequestMapping("/api/v1")
public class BasicAuthController {

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}
}
