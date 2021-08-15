package app.web.safetravels.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="hotel")
public class Hotel {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="hotelname")
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private String address;
	@Getter
	@Setter
	private String city;
	@Getter
	@Setter
	private String province;
	@Getter
	@Setter
	private String hdescription;
	@Getter
	@Setter
	private String email;
	@Getter
	@Setter
	private String phone;
	//I will need a relation for something like this later:
//	private Map<String, Integer> numberOfRoomsPerType;
	@Getter
	@Setter
	private int numberOfRooms;
	@Getter
	@Setter
	private double rating;
	@Getter
	@Setter
	private double price;
	@Getter
	@Setter
	private short stars;
	@Getter
	@Setter
	private boolean pool;
	@Getter
	@Setter
	private boolean spa;
	@Getter
	@Setter
	private boolean wifi;
	@Getter
	@Setter
	private boolean parking;
	@Getter
	@Setter
	private boolean pets;
	@Getter
	@Setter
	private boolean recommended;
	@Getter
	@Setter
	private int discount;


}