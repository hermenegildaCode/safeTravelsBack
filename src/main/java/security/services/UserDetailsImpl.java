package security.services;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.web.safetravels.entity.Usr;
import lombok.Getter;
import lombok.Setter;

public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	private String firstname;
	@Setter
	@Getter
	private String lastname;
	@Setter
	@Getter
	private String country;
	@Setter
	@Getter
	private Date birthdate;
	@Getter
	private String email;
	@Getter
	@JsonIgnore
	private String passwd;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(String email, String passwd, String firstname, String lastname, String phone,
			String country, Date birthdate, Collection<? extends GrantedAuthority> authorities) {
		this.email = email;
		this.passwd = passwd;
		this.firstname = firstname;
		this.lastname = lastname;
		this.country = country;
		this.birthdate = birthdate;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(Usr user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getEmail(),
				user.getPasswd(),
				user.getFirstname(),
				user.getLastname(),
				user.getPhone(),
				user.getCountry(),
				user.getBirthdate(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(email, user.email);
	}

	@Override
	public String getPassword() {
		return passwd;
	}

	@Override
	public String getUsername() {
		return email;
	}
}
