package app.web.safetravels.security.services;

import java.util.List;

import app.web.safetravels.entity.Usr;

public interface IUserService {
	public List<Usr> findByCountry(String country);
	public Usr findByEmail(String email);
	public Usr findByUsername(String username);
	public Usr signup(Usr u);
	public Boolean existsByEmail(String email);
}
