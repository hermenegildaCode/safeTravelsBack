package app.web.safetravels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.web.safetravels.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{
	List<Booking> findByEmail(String email);

	List<Booking> findByHotelId(int hotelId);
}
