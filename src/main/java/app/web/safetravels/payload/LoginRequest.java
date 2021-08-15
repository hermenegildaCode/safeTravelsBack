package app.web.safetravels.payload;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
//	@NotBlank
//	private String email;

	@NotBlank
	private String passwd;
	@NotBlank
	private String username;

//	public String getEmail() {
//		return email;
//	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String password) {
		this.passwd = password;
	}

	public Object getUsername() {
		return this.username;
	}
}