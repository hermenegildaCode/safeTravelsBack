package app.web.safetravels.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="room")
public class Room {
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private int roomId;
	@Getter
	@Setter
	private int hotelId;
	@Getter
	@Setter
	private String roomType;
	@Getter
	@Setter
	private int maxHosts;
	@Getter
	@Setter
	private double price;
	@Getter
	@Setter
	private boolean privateBathroom;
	@Getter
	@Setter
	private boolean privateToilet;
	@Getter
	@Setter
	private boolean mountainView;
	@Getter
	@Setter
	private boolean seaView;
	@Getter
	@Setter
	private boolean balcony;
	@Getter
	@Setter
	private boolean ac;
	@Getter
	@Setter
	private boolean minibar;
	@Getter
	@Setter
	private boolean flatScreenTv;
	@Getter
	@Setter
	private boolean jacuzzi;
	@Getter
	@Setter
	private int numberOfRoomsLikeThis;
	
}
