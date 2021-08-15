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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(	name = "usr", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "username"),
})
public class Usr {
	@Id
	private String email;
	@Getter
	@Setter
	private String username;
	private String passwd;
//	private String phone;
//	private String firstname;
//	private String lastname;
//	private String country;
//	private Date birthdate;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "usr_role", 
				joinColumns = @JoinColumn(name = "usr_email"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();

	public Usr(String email, String username, String passwd) {
		this.email = email;
		this.username = username;
		this.passwd = passwd;
	}

	public Usr(String username, String passwd) {
		this.username = username;
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

//	public String getFirstname() {
//		return firstname;
//	}
//
//	public void setFirstname(String firtname) {
//		this.firstname = firtname;
//	}
//
//	public String getLastname() {
//		return lastname;
//	}
//
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	public Date getBirthdate() {
//		return birthdate;
//	}
//
//	public void setBirthdate(Date birthdate) {
//		this.birthdate = birthdate;
//	}



	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}