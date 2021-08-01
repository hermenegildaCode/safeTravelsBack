package app.web.safetravels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.web.safetravels.entity.Booking;
import app.web.safetravels.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRespository;
	
	public Booking saveBooking (Booking book) {
		return bookingRespository.save(book);
	}
	public List<Booking> saveBookings(List<Booking> hotels){
		return bookingRespository.saveAll(hotels);
	}
	public List<Booking> getAllBookings(){
		return bookingRespository.findAll();
	}
	public Booking getBookingById(int id) {
		return bookingRespository.findById(id).orElse(null);
	}
	public List<Booking> getBookingsByHotel(int hotelId) {
		return bookingRespository.findByHotelId(hotelId);
	}
	public List<Booking> getBookingsByEmail(String email) {
		return bookingRespository.findByEmail(email);
	}
	
	public String deleteHotel(int id) {
		bookingRespository.deleteById(id);
		return "reserva elimanda: " + id;
	}
	public Booking updateBooking(Booking booking){
		Booking existingBooking= bookingRespository.findById(booking.getBookingId()).orElse(null);
		existingBooking.setEmail(booking.getEmail());
		existingBooking.setCheckinDate(booking.getCheckinDate());
		existingBooking.setCheckoutDate(booking.getCheckoutDate());
		return bookingRespository.save(existingBooking);
	}
}
