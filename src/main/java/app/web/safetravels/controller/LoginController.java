package app.web.safetravels.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import app.web.safetravels.entity.Usr;
import app.web.safetravels.security.services.IUserService;

public class LoginController {
	@Autowired
	private IUserService userService;
	
	@GetMapping("/auth/signup")
	public String signupForm(Model model) {
		model.addAttribute("user", new Usr());
		return "register";
	}
	@PostMapping("/auth/signup")
	public String signup(@Valid @ModelAttribute Usr user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "redirect:/auth/signup";
		}else {
			model.addAttribute("usr", userService.signup(user));
		}
		return "redirect:/auth/login";
	}
	
}
