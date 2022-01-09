package app.web.safetravels.controller;


	import org.springframework.security.access.prepost.PreAuthorize;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	@CrossOrigin(origins = {"http://localhost:4200", "http://safetravelss.herokuapp.com", "https://safetravelss.herokuapp.com", "https://safetravelz.herokuapp.com", "https://safetravelz.herokuapp.com/web"})
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
