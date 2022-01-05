package app.web.safetravels.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.web.safetravels.entity.Booking;
import app.web.safetravels.entity.Hotel;
import app.web.safetravels.entity.Room;
import app.web.safetravels.exceptions.RoomsNotLeftException;
import app.web.safetravels.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRespository;
	@Autowired
	private RoomService roomService;
	@Autowired
	private HotelService hotelService;
	public Hotel getHotelByHotelId(int hotelId) {
		return hotelService.getHotelById(hotelId);
	}
	public static List<Date> getDatesInRange(
			  Date startDate, Date endDate) throws ParseException {
			    List<Date> datesInRange = new ArrayList<Date>();
			    Calendar calendar = new GregorianCalendar();
			    calendar.setTime(startDate);
			    
			    Calendar endCalendar = new GregorianCalendar();
			    endCalendar.setTime(endDate);

			    while (calendar.before(endCalendar)) {
//			    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			        Date result = calendar.getTime();
			        String formattedDateStr = new SimpleDateFormat("dd/MM/yyyy").format(result);
			        Date formattedDate = new SimpleDateFormat("dd/MM/yyyy").parse(formattedDateStr);
			        datesInRange.add(formattedDate);
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
	public boolean areRoomsThisTypeAvailable(Booking booking) throws ParseException {
		List<Date> bookingDatesRange = getDatesInRange(booking.getCheckinDate(), booking.getCheckoutDate());
		int totalNumberOfRooms= totalRoomsOfThisType(booking);
		int roomsLeft = totalNumberOfRooms;
		boolean areAnyRoomsLeft = true;
		List<Booking> totalBookingsThisRoomType = bookingRespository.findAllByRoomId(booking.getRoomId());
		isBookedDateRange:
		for (Date date: bookingDatesRange) {
			for (Booking bookingRoomType : totalBookingsThisRoomType) {
				List<Date> dateRangeForThisRoom = getDatesInRange(bookingRoomType.getCheckinDate(), bookingRoomType.getCheckoutDate());
				for (Date bookingRoomTypeDate : dateRangeForThisRoom) {
					//if comparison = true it means the dates are equal. if it less than 0 date 1 comes after date2. 
					if(bookingRoomTypeDate.compareTo(date) == 0) {
						roomsLeft--;
						if(roomsLeft == 0) {
							areAnyRoomsLeft = false;
							break isBookedDateRange;
						}
					}
				}
				
			}
		}	
		return areAnyRoomsLeft;
	}
	public void saveBooking (Booking booking) throws RoomsNotLeftException, ParseException {
//		if(areRoomsThisTypeAvailable(booking) == false) {
//			throw new RoomsNotLeftException("There are not any rooms left of this type.");
//		} else {
			bookingRespository.save(booking);
//		}
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
