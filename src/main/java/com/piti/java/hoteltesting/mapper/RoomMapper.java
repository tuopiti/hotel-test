package com.piti.java.hoteltesting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.piti.java.hoteltesting.dto.RoomDTO;
import com.piti.java.hoteltesting.model.Room;
import com.piti.java.hoteltesting.service.HotelService;

@Mapper(componentModel = "spring", uses = {HotelService.class})
public interface RoomMapper {
	RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
	
	@Mapping(target = "hotel", source = "roomDTO.hotelId")
	Room toEntity(RoomDTO roomDTO);
	
	@Mapping(target = "hotelId", source = "hotel.id")
	RoomDTO toDTO(Room room);
}
