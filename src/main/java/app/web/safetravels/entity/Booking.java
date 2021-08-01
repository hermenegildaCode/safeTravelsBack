package app.web.safetravels.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="booking")

public class Booking {
	@Id
	private int bookingId;
	private String email;
	private int hotelId;
	private Date checkinDate;
	private Date checkoutDate;
	private boolean cancelled;
	private boolean breakfastIncluded;
	@Getter
	@Setter
	private double price;
	
	public Booking(int bookingId, String email, int hotelId, Date checkinDate, Date checkoutDate, boolean cancelled,
			boolean breakfastIncluded, double totalPrice, String review, int rating) {
		super();
		this.bookingId = bookingId;
		this.email = email;
		this.hotelId = hotelId;
		this.checkinDate = checkinDate;
		this.checkoutDate = checkoutDate;
		this.cancelled = cancelled;
		this.breakfastIncluded = breakfastIncluded;
	}


	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public Date getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public boolean isCancelled() {
		return cancelled;
	}
	
//	public Hotel getHotelByBooking(Booking booking){
//		Hotel hotel = hotel.getHotelById(booking.getHotelId());
//		return 
//	}
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}
	public boolean isBreakfastIncluded() {
		return breakfastIncluded;
	}
	public void setBreakfastIncluded(boolean breakfastIncluded) {
		this.breakfastIncluded = breakfastIncluded;
	}
}
