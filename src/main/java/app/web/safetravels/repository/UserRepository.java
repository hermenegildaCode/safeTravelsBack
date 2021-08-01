package app.web.safetravels.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.web.safetravels.entity.Usr;


public interface UserRepository extends JpaRepository<Usr, String> {
	List<Usr> findByCountry(String country);
	Usr findByEmail(String email);
	Usr findByUsername(String username);
	Boolean existsByEmail(String email);
}
