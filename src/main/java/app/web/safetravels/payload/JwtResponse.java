package app.web.safetravels.payload;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String username;
	private String email;
	private List<String> roles;

	public JwtResponse(String accessToken, List<String> roles, String username) {
		this.token = accessToken;
		this.username = username;
		this.roles = roles;
	}
	public JwtResponse(String accessToken, List<String> roles, String username, String email) {
		this.token = accessToken;
		this.username = username;
		this.roles = roles;
		this.email = email;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}