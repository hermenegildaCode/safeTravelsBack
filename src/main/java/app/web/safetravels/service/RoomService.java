package app.web.safetravels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.web.safetravels.entity.Room;
import app.web.safetravels.repository.RoomRepository;

@Service
public class RoomService {
	@Autowired
	private RoomRepository roomRepository;
	public Room saveRoom(Room room) {
		return roomRepository.save(room);
	}
	public List<Room> getAllRooms(){
		return roomRepository.findAll();
	}
	public Room getRoomById(int roomId) {
		return roomRepository.findById(roomId).orElse(null);
	}
	public List<Room> getRoomsByHotel(int hotelId) {
		return roomRepository.findByHotelId(hotelId);
	}
	
	public String deleteRoom(int id) {
		roomRepository.deleteById(id);
		return "erased room: " + id;
	}
	
	public String deleteAllRooms() {
		roomRepository.deleteAll();
		return "erased all rooms";
	}
	
	public String deleteRoomsByHotel(int hotelId) {
		roomRepository.deleteAll(getRoomsByHotel(hotelId));
		return "deleted all rooms for hotel with id " + hotelId;
	}
	public Room updateRoom (Room room){
		Room existingRoom= roomRepository.findById(room.getRoomId()).orElse(null);
		existingRoom.setHotelId(room.getHotelId());
		existingRoom.setMaxHosts(room.getMaxHosts());
		existingRoom.setRoomType(room.getRoomType());
		existingRoom.setAc(room.isAc());
		existingRoom.setBalcony(room.isBalcony());
		existingRoom.setFlatScreenTv(room.isFlatScreenTv());
		existingRoom.setMinibar(room.isMinibar());
		existingRoom.setMountainView(room.isMountainView());
		existingRoom.setPrivateBathroom(room.isPrivateBathroom());
		existingRoom.setPrivateToilet(room.isPrivateToilet());
		existingRoom.setSeaView(room.isSeaView());
		return roomRepository.save(existingRoom);
	}
}
