package app.web.safetravels.payload;

import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest { 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    private String username;
    
    private Set<String> roles;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String passwd;
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPasswd() {
        return passwd;
    }
 
    public void setPasswd(String password) {
        this.passwd = password;
    }
    
    public Set<String> getRoles() {
      return this.roles;
    }
    
    public void setRoles(Set<String> roles) {
      this.roles = roles;
    }

	public String getUsername() {
		
		return this.username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
}