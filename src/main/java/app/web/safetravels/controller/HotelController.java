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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.web.safetravels.entity.Hotel;
import app.web.safetravels.service.HotelService;

@RestController
public class HotelController {
	@Autowired
	private HotelService hservice;
	@PostMapping("/addHotel")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return hservice.saveHotel(hotel);
	}
	@PostMapping("/addHotels")
	public List<Hotel> addHotels(@RequestBody List<Hotel> hotel) {
		return hservice.saveHotels(hotel);
	}
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/api/o/hotels")
	public List<Hotel> findAllHotels() {
		return hservice.getAllHotels();
	}
	@CrossOrigin("http://localhost:4200")
	@GetMapping("hotelByName/{name}")
	public Hotel findHotelByName(@PathVariable String name) {
		return hservice.getHotelByName(name);
	}
	@CrossOrigin("http://localhost:4200")
	@GetMapping("hotel/{id}")
	public Hotel findHotelById(@PathVariable int id) {
		return hservice.getHotelById(id);
	}
	@GetMapping("hotels/{province}")
	public List<Hotel> findHotelsByProvince(String province) {
		return hservice.getHotelsByProvince(province);
	}
	@PutMapping("/updateHotel/{id}")
//	public Boolean updateHotel(@RequestBody Hotel hotel, int id) {
//		return hservice.updateHotel(id, hotel);
//	}
	@RequestMapping(value = "/updateHotel/{id}", method = RequestMethod.PUT)
	public void updateHotel(@RequestBody Hotel hotel, @PathVariable int id) {
	     hservice.updateHotel(id, hotel);
	}
	@DeleteMapping("deleteHotel/{id}")
	public String deleteHotel(@PathVariable int id) {
		return hservice.deleteHotel(id);
	}
}
