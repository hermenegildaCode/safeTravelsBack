package app.web.safetravels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.web.safetravels.entity.Hotel;
import app.web.safetravels.repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRespository;

	public Hotel saveHotel(Hotel hotel) {
		return hotelRespository.save(hotel);
	}

	public List<Hotel> saveHotels(List<Hotel> hotels) {
		return hotelRespository.saveAll(hotels);
	}

	public List<Hotel> getAllHotels() {
		return hotelRespository.findAll();
	}

	public Hotel getHotelById(int id) {
		return hotelRespository.findById(id).orElse(null);
	}

	public Hotel getHotelByName(String name) {
		return hotelRespository.findByName(name);
	}

	public List<Hotel> getHotelsByProvince(String province) {
		return hotelRespository.findByProvince(province);
	}

	public String deleteHotel(int id) {
		hotelRespository.deleteById(id);
		return "hotel elimando: " + id;
	}

	public Hotel oldmethodUpdateHotel(int id, Hotel hotel) {
		Hotel existingHotel = hotelRespository.findById(id).orElse(null);
		existingHotel.setName(hotel.getName());
		existingHotel.setAddress(hotel.getAddress());
		existingHotel.setCity(hotel.getCity());
		existingHotel.setProvince(hotel.getProvince());
		existingHotel.setDiscount(hotel.getDiscount());
		existingHotel.setNumberOfRooms(hotel.getNumberOfRooms());
		existingHotel.setEmail(hotel.getEmail());
		existingHotel.setRating(hotel.getRating());
		existingHotel.setRecommended(hotel.isRecommended());
		existingHotel.setPrice(hotel.getPrice());
		return hotelRespository.save(existingHotel);
	}

	
	public Hotel updateHotel(int id, Hotel hotel) {
		Hotel existingHotel = hotelRespository.findById(id).get();
		existingHotel.setName(hotel.getName());
		existingHotel.setAddress(hotel.getAddress());
		existingHotel.setCity(hotel.getCity());
		existingHotel.setProvince(hotel.getProvince());
		existingHotel.setDiscount(hotel.getDiscount());
		existingHotel.setNumberOfRooms(hotel.getNumberOfRooms());
		existingHotel.setEmail(hotel.getEmail());
		existingHotel.setRating(hotel.getRating());
		existingHotel.setRecommended(hotel.isRecommended());
		existingHotel.setPrice(hotel.getPrice());
		return hotelRespository.save(existingHotel);
		
	}


}
