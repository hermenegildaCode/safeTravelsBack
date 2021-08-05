package app.web.safetravels.security.services;

import org.springframework.security.core.AuthenticationException;

public class EmailNotFoundException extends  AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a <code>UsernameNotFoundException</code> with the specified message.
	 * @param msg the detail message.
	 */
	public EmailNotFoundException(String msg) {
		super(msg);
	}

	/**
	 * Constructs a {@code UsernameNotFoundException} with the specified message and root
	 * cause.
	 * @param msg the detail message.
	 * @param cause root cause
	 */
	public EmailNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
