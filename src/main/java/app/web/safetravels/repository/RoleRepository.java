package app.web.safetravels.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.web.safetravels.entity.Role;
import app.web.safetravels.entity.RoleEnum;
//public interface RoleRepository{
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByRolename(RoleEnum rolename);

}
