package app.web.safetravels;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost", "http://safetravels.fly.dev/", "https://safetravels.fly.dev/", "https://safetravelz.fly.dev/", "https://safetravelz.fly.dev/web"})
@RestController
@RequestMapping("/api")
public class BasicAuthController {

	@GetMapping(path = "/basicauth")
	public AuthenticationBean basicauth() {
		return new AuthenticationBean("You are authenticated");
	}
}
