package com.piti.java.hoteltesting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.piti.java.hoteltesting.dto.HotelDTO;
import com.piti.java.hoteltesting.model.Hotel;
import com.piti.java.hoteltesting.service.LocationService;
import com.piti.java.hoteltesting.service.UserService;

@Mapper(componentModel = "spring",uses = {LocationService.class, UserService.class})
public interface HotelMapper {
	
	@Mapping(target = "location", source = "hotelDTO.locationId")
	@Mapping(target = "owner", source = "hotelDTO.ownerId")
	Hotel toEntity(HotelDTO hotelDTO);
	
	@Mapping(target = "locationId", source = "location.id")
	@Mapping(target = "ownerId", source = "owner.id")
	HotelDTO toDTO(Hotel hotel);
}
