package app.web.safetravels.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.web.safetravels.entity.Room;


public interface RoomRepository extends JpaRepository<Room, Integer>{

	List<Room> findByHotelId(int hotelId);

}
