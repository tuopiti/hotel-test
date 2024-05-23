package com.piti.java.hoteltesting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.piti.java.hoteltesting.dto.HotelDTO;
import com.piti.java.hoteltesting.model.Hotel;
import com.piti.java.hoteltesting.service.LocationService;

@Mapper(componentModel = "spring",uses = {LocationService.class})
public interface HotelMapper {
	
	@Mapping(target = "location", source = "hotelDTO.locationId")
	Hotel toEntity(HotelDTO hotelDTO);
	
	@Mapping(target = "locationId", source = "location.id")
	HotelDTO toDTO(Hotel hotel);
}
