package app.web.safetravels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.web.safetravels.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	List<Hotel> findByProvince(String province);

	Hotel findByName(String name);
	
}

