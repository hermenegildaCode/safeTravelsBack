package app.web.safetravels.controller;

import java.text.ParseException;
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

import app.web.safetravels.entity.Booking;
import app.web.safetravels.entity.Hotel;
import app.web.safetravels.exceptions.RoomsNotLeftException;
import app.web.safetravels.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	private BookingService bservice;
	@CrossOrigin(origins = {"http://localhost:4200", "http://safetravelss.herokuapp.com", "https://safetravelss.herokuapp.com", "https://safetravelz.herokuapp.com", "https://safetravelz.herokuapp.com/web"})@PostMapping("/addBooking")
	public void addBooking(@RequestBody Booking booking) throws RoomsNotLeftException, ParseException {
		bservice.saveBooking(booking);
	}
	@PostMapping("/addBookings")
	public List<Booking> addBookings(@RequestBody List<Booking> bookings) {
		return bservice.saveBookings(bookings);
	}
	@CrossOrigin(origins = {"http://localhost:4200", "http://safetravelss.herokuapp.com", "https://safetravelss.herokuapp.com", "https://safetravelz.herokuapp.com", "https://safetravelz.herokuapp.com/web"})@GetMapping("/bookings")
	public List<Booking> findAllBookings() {
		return bservice.getAllBookings();
	}
	@CrossOrigin(origins = {"http://localhost:4200", "http://safetravelss.herokuapp.com", "https://safetravelss.herokuapp.com", "https://safetravelz.herokuapp.com", "https://safetravelz.herokuapp.com/web"})
	@GetMapping("bookingsByHotel/{hotel}")
	public List<Booking> findBookingsByHotelId(@PathVariable int hotel) {
		return bservice.getBookingsByHotel(hotel);
	}
	@CrossOrigin(origins = {"http://localhost:4200", "http://safetravelss.herokuapp.com", "https://safetravelss.herokuapp.com", "https://safetravelz.herokuapp.com", "https://safetravelz.herokuapp.com/web"})
	@GetMapping("bookingById/{id}")
	public Booking findBookingById(@PathVariable int id) {
		return bservice.getBookingById(id);
	}

	@CrossOrigin(origins = {"http://localhost:4200", "https://safetravelss.herokuapp.com", "https://safetravelz.herokuapp.com", "https://safetravelz.herokuapp.com/web"})
	@GetMapping("bookings/{username}")
	public List<Booking> findBookingsByUsername(@PathVariable String username) {
		return bservice.getBookingsByUsername(username);
	}
	
	@CrossOrigin(origins = {"http://localhost:4200", "http://safetravelss.herokuapp.com", "https://safetravelss.herokuapp.com", "https://safetravelz.herokuapp.com", "https://safetravelz.herokuapp.com/web"})@GetMapping("hotelByHotelId/{hotelId}")
	public Hotel findHotelByBooking(@PathVariable int hotelId) {
	return bservice.getHotelByHotelId(hotelId);
	}

	@PutMapping("/updateBooking")
	public Booking updateBooking(@RequestBody Booking booking) {
		return bservice.updateBooking(booking);
	}
	@DeleteMapping("deleteBooking/{bookingId}")
	public String deleteBookingById(@PathVariable int bookingId) {
		return bservice.deleteBookingById(bookingId);
	}
	@DeleteMapping("deleteBookings")
	public String deleteAllBookings() {
		return bservice.deleteAllBookings();
	}
}
