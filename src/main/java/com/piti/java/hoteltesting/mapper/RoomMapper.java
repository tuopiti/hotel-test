package com.piti.java.hoteltesting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.piti.java.hoteltesting.dto.RoomDTO;
import com.piti.java.hoteltesting.model.Room;

@Mapper(componentModel = "spring")
public interface RoomMapper {
	RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);
	
	Room toEntity(RoomDTO roomDTO);
	RoomDTO toDTO(Room room);
}
