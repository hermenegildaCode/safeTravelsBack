package app.web.safetravels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.web.safetravels.entity.Booking;
import app.web.safetravels.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	private BookingService bservice;
	@PostMapping("/addBooking")
	public Booking addBooking(@RequestBody Booking booking) {
		return bservice.saveBooking(booking);
	}
	@PostMapping("/addBookings")
	public List<Booking> addBookings(@RequestBody List<Booking> bookings) {
		return bservice.saveBookings(bookings);
	}
	@GetMapping("/bookings")
	public List<Booking> findAllBookings() {
		return bservice.getAllBookings();
	}
	@GetMapping("bookings/{hotel}")
	public List<Booking> findBookingsByHotelId(@PathVariable int hotel) {
		return bservice.getBookingsByHotel(hotel);
	}
	@GetMapping("bookingById/{id}")
	public Booking findBookingById(@PathVariable int id) {
		return bservice.getBookingById(id);
	}
	@GetMapping("bookingsByEmail/{email}")
	public List<Booking> findBookingsByEmail(String email) {
		return bservice.getBookingsByEmail(email);
	}
	@PutMapping("/updateBooking")
	public Booking updateHotel(@RequestBody Booking booking) {
		return bservice.updateBooking(booking);
	}
	@DeleteMapping("deleteBooking/{id}")
	public String deleteHotel(@PathVariable int id) {
		return bservice.deleteHotel(id);
	}
}
