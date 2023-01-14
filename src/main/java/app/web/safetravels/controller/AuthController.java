package app.web.safetravels.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.BeanIds;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import app.web.safetravels.entity.Role;
import app.web.safetravels.entity.RoleEnum;
import app.web.safetravels.entity.Usr;
import app.web.safetravels.payload.JwtResponse;
import app.web.safetravels.payload.LoginRequest;
import app.web.safetravels.payload.MessageResponse;
import app.web.safetravels.payload.SignupRequest;
import app.web.safetravels.repository.RoleRepository;
import app.web.safetravels.repository.UserRepository;
import app.web.safetravels.security.JwtUtils;
import app.web.safetravels.security.services.UserDetailsImpl;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	@Qualifier(BeanIds.AUTHENTICATION_MANAGER)
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	@CrossOrigin(origins = {"http://localhost:4200", "https://site--front--p6vkzqn94x74.code.run/", "http://safetravelss.herokuapp.com", "https://safetravelss.herokuapp.com", "https://safetravelz.herokuapp.com", "https://safetravelz.herokuapp.com/web"})
	@PostMapping("api/auth/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPasswd()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 roles, 
												 userDetails.getUsername(), userDetails.getEmail()));
//		return ResponseEntity.ok(new JwtResponse(jwt,
//				 roles, 
//				 userDetails.getUsername()));
	}
	@CrossOrigin(origins = {"http://localhost:4200", "http://safetravelss.herokuapp.com", "https://safetravelss.herokuapp.com", "https://safetravelz.herokuapp.com", "https://safetravelz.herokuapp.com/web"})
	@PostMapping("api/auth/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		Usr user = new Usr(signUpRequest.getEmail(), signUpRequest.getUsername(),
							 encoder.encode(signUpRequest.getPasswd()));

		Set<String> strRoles = signUpRequest.getRoles();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByRolename(RoleEnum.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByRolename(RoleEnum.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByRolename(RoleEnum.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByRolename(RoleEnum.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}