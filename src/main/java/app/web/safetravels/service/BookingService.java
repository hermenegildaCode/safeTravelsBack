package app.web.safetravels.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.web.safetravels.entity.Booking;
import app.web.safetravels.entity.Room;
import app.web.safetravels.exceptions.RoomsNotLeftException;
import app.web.safetravels.repository.BookingRepository;
import app.web.safetravels.repository.RoomRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRespository;
	@Autowired
	private RoomService roomService;
	
	public static List<Date> getDatesInRange(
			  Date startDate, Date endDate) {
			    List<Date> datesInRange = new ArrayList<Date>();
			    Calendar calendar = new GregorianCalendar();
			    calendar.setTime(startDate);
			    
			    Calendar endCalendar = new GregorianCalendar();
			    endCalendar.setTime(endDate);

			    while (calendar.before(endCalendar)) {
			        Date result = calendar.getTime();
			        datesInRange.add(result);
			        calendar.add(Calendar.DATE, 1);
			    }
			    return datesInRange;
			}
	public Room bookedRoom(Booking booking) {
		return roomService.getRoomById(booking.getRoomId());
	}
		
	public int totalRoomsOfThisType(Booking booking) {
		Room bookedRoom = bookedRoom(booking);
		int totalNumberOfRooms = bookedRoom.getNumberOfRoomsLikeThis();
		return totalNumberOfRooms;
	}
	
	public List<Booking> getAllBookingsByRoomId(int roomId){
		return bookingRespository.findAllByRoomId(roomId);
	}
	public int existingBookingsForThisRoomType(Booking booking){
		List<Booking> totalBookingsThisRoomType = bookingRespository.findAllByRoomId(booking.getRoomId());
		return totalBookingsThisRoomType.size();
	}
	public boolean areRoomsThisTypeAvailable(Booking booking) {
		List<Date> bookingDatesRange = getDatesInRange(booking.getCheckinDate(), booking.getCheckoutDate());
		int totalNumberOfRooms= booking.getRoomId();
		int roomsLeft = totalNumberOfRooms;
		boolean areAnyRoomsLeft = true;
		List<Booking> totalBookingsThisRoomType = bookingRespository.findAllByRoomId(booking.getRoomId());
		for (Date date: bookingDatesRange) {
			for (Booking bookingRoomType : totalBookingsThisRoomType) {
				List<Date> dateRangeForThisRoom = getDatesInRange(bookingRoomType.getCheckinDate(), bookingRoomType.getCheckoutDate());
				for (Date bookingRoomTypeDate : dateRangeForThisRoom) {
					if(bookingRoomTypeDate == date) {
						roomsLeft--;
						if(roomsLeft == 0) {
							areAnyRoomsLeft = false;
							break;
						}
					}
				}
				
			}
		}	
		return areAnyRoomsLeft;
	}
	public void saveBooking (Booking booking) throws RoomsNotLeftException {
		if(areRoomsThisTypeAvailable(booking) == false) {
			throw new RoomsNotLeftException("There are not any rooms left of this type.");
		} else {
			bookingRespository.save(booking);
		}
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
	public List<Booking> getBookingsByUsername(String username) {
		return bookingRespository.findByUsername(username);
	}
	
	public String deleteBookingById(int id) {
		bookingRespository.deleteById(id);
		return "reserva elimanda: " + id;
	}
	public Booking updateBooking(Booking booking){
		Booking existingBooking= bookingRespository.findById(booking.getBookingId()).orElse(null);
		existingBooking.setUsername(booking.getUsername());
		existingBooking.setCheckinDate(booking.getCheckinDate());
		existingBooking.setCheckoutDate(booking.getCheckoutDate());
		return bookingRespository.save(existingBooking);
	}

	
	public String deleteAllBookings() {
		bookingRespository.deleteAll();
		return "All bookings deleted";
	}


}
