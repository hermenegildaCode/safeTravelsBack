package app.web.safetravels.controller;


	import org.springframework.security.access.prepost.PreAuthorize;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@CrossOrigin(origins = {"http://localhost", "http://safetravels.fly.dev/", "https://safetravels.fly.dev/", "https://safetravelz.fly.dev/", "https://safetravelz.fly.dev/web"})
	@RestController
	@RequestMapping("/api")
	public class TestController {
		@GetMapping("/o")
		public String allAccess() {
			return "Public Content.";
		}
		
		@GetMapping("/user")
		@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
		public String userAccess() {
			return "User Content.";
		}

		@GetMapping("/mod")
		@PreAuthorize("hasRole('MODERATOR')")
		public String moderatorAccess() {
			return "Moderator Board.";
		}

		@GetMapping("/admin")
		@PreAuthorize("hasRole('ADMIN')")
		public String adminAccess() {
			return "Admin Board.";
		}
}
