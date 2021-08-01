package app.web.safetravels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationBean {
	private String message;
	@Getter
	@Setter
	private boolean loggedInUsr;

    public AuthenticationBean(String message) {
        this.message = message;
        this.loggedInUsr = true;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    

    @Override
    public String toString() {
        return String.format("[message=%s]", message);
    }
}
