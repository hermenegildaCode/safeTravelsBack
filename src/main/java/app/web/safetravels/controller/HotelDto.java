package app.web.safetravels.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
	@Getter @Setter private int id;
	@Getter @Setter private String name;
	@Getter @Setter private String address;
	@Getter @Setter private String city;
	@Getter @Setter private String region;
	@Getter @Setter private String email;
	@Getter @Setter private String phone;
	@Getter @Setter private int numberOfRooms;
	@Getter @Setter private double rating;
	@Getter @Setter private double price;
	@Getter @Setter private short stars;
	@Getter @Setter private boolean pool;
	@Getter @Setter private boolean spa;
	@Getter @Setter private boolean wifi;
	@Getter @Setter private boolean parking;
	@Getter @Setter private boolean airportShuttle;
	@Getter @Setter private boolean pets;
	@Getter @Setter private boolean electricStation;
	@Getter @Setter private boolean recommended;
	@Getter @Setter private int discount;
	
//	@Mapper(componentModel = "spring")
//	public interface HotelMapper {
//		@BeanMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
//		void updateHotelFromDto(HotelDto dto, @MappingTarget Hotel entity);
//	}

}
