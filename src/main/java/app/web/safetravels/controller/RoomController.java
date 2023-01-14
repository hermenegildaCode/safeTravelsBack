package app.web.safetravels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.web.safetravels.entity.Room;
import app.web.safetravels.service.RoomService;


@RestController
public class RoomController {
	@Autowired
	RoomService roomService;

	@PostMapping("/addRoom")
	public Room addRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}
	@CrossOrigin(origins = {"http://localhost", "http://safetravels.fly.dev/", "https://safetravels.fly.dev/", "https://safetravelz.fly.dev/", "https://safetravelz.fly.dev/web"})
	@GetMapping("/rooms")
	public List<Room> findAllRooms() {
		return roomService.getAllRooms();
	}
	@CrossOrigin(origins = {"http://localhost", "http://safetravels.fly.dev/", "https://safetravels.fly.dev/", "https://safetravelz.fly.dev/", "https://safetravelz.fly.dev/web"})
	@GetMapping("/room/{id}")
	public Room findRoomById(@PathVariable int id) {
		return roomService.getRoomById(id);
	}
	@CrossOrigin(origins = {"http://localhost", "http://safetravels.fly.dev/", "https://safetravels.fly.dev/", "https://safetravelz.fly.dev/", "https://safetravelz.fly.dev/web"})
	@GetMapping("/hotel/{id}/rooms")
	public List<Room> findRoomsByHotel(@PathVariable int id) {
		return roomService.getRoomsByHotel(id);
	}

	@PutMapping("/updateRoom")
	public Room updateRoom(@RequestBody Room room) {
		return roomService.updateRoom(room);
	}

	@DeleteMapping("/deleteRoom/{id}")
	public String deleteRoom(@PathVariable int id) {
		return roomService.deleteRoom(id);
	}
	@DeleteMapping("/delete/rooms")
	public String deleteAllRooms() {
		return roomService.deleteAllRooms();
	}
	@DeleteMapping("/deleteRooms/hotel/{hotelId}")
	public String deleteRoomsByHotel(@PathVariable int hotelId) {
		return roomService.deleteRoomsByHotel(hotelId);
	}
}
