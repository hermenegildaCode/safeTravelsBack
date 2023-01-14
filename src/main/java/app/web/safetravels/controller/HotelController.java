   package app.web.safetravels.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
//	@CrossOrigin(origins = {"http://localhost:4200", "https://safetravelss.herokuapp.com", "https://safetravelz.herokuapp.com", "https://safetravelz.herokuapp.com/web"})
//	@GetMapping("/hotels")
//	public List<Hotel> findAllHotels() {
//		return hservice.getAllHotels();
//	}
	@CrossOrigin(origins = {"http://localhost", "https://site--front--p6vkzqn94x74.code.run/", "http://safetravels.fly.dev/", "https://safetravels.fly.dev/", "https://safetravelz.fly.dev/", "https://safetravelz.fly.dev/web"})
	@GetMapping("/hotels")
	  public ResponseEntity<List<Hotel>> getAllHotels(@RequestParam(required = false) String name) {
	    try {
	      List<Hotel> hotels = new ArrayList<Hotel>();

	      if (name == null)
	    	  hservice.getAllHotels().forEach(hotels::add);
	      else
	        hservice.getHotelsByName(name).forEach(hotels::add);

	      if (hotels.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(hotels, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@CrossOrigin(origins = {"http://localhost", "https://site--front--p6vkzqn94x74.code.run/", "http://safetravels.fly.dev/", "https://safetravels.fly.dev/", "https://safetravelz.fly.dev/", "https://safetravelz.fly.dev/web"})
	@GetMapping("hotelByName/{name}")
	public Hotel findHotelByName(@PathVariable String name) {
		return hservice.getHotelByName(name);
	}
	@CrossOrigin(origins = {"http://localhost", "https://site--front--p6vkzqn94x74.code.run/", "http://safetravels.fly.dev/", "https://safetravels.fly.dev/", "https://safetravelz.fly.dev/", "https://safetravelz.fly.dev/web"})
	@GetMapping("hotel/{id}")
	public Hotel findHotelById(@PathVariable int id) {
		return hservice.getHotelById(id);
	}	

	@CrossOrigin(origins = {"http://localhost", "https://site--front--p6vkzqn94x74.code.run/", "http://safetravels.fly.dev/", "https://safetravels.fly.dev/", "https://safetravelz.fly.dev/", "https://safetravelz.fly.dev/web"})
	@GetMapping("hotelsByProvince/{province}")
	public List<Hotel> findHotelsByProvince(@PathVariable String province) {
		return hservice.getHotelsByProvince(province);
	}
	@CrossOrigin(origins = {"http://localhost", "https://site--front--p6vkzqn94x74.code.run/", "http://safetravels.fly.dev/", "https://safetravels.fly.dev/", "https://safetravelz.fly.dev/", "https://safetravelz.fly.dev/web"})
	@GetMapping("hotelsByCity/{city}")
	public List<Hotel> findHotelsByCity(@PathVariable String city) {
		return hservice.getHotelsByCity(city);
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
