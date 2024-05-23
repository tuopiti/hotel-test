package com.piti.java.hoteltesting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.piti.java.hoteltesting.dto.LocationDTO;
import com.piti.java.hoteltesting.model.Location;

@Mapper
public interface LocationMapper {
	LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);
	
	Location toEntity(LocationDTO locationDTO);
	LocationDTO toDTO(Location location);
}
