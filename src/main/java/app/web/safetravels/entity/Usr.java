package app.web.safetravels.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usr")
public class Usr {
	@Id
	private String email;
	private String username;
	private String passwd;
	private String phone;
	private String firstname;
	private String lastname;
	private String country;
	private Date birthdate;

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(	name = "usr_roles", 
//				joinColumns = @JoinColumn(name = "usr_email"), 
//				inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> roles = new HashSet<Role>();

	public Usr(String email, String passwd) {
		this.email= email;
		this.passwd = passwd;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firtname) {
		this.firstname = firtname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}


}