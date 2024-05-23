package com.piti.java.hoteltesting.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.piti.java.hoteltesting.dto.LocationDTO;
import com.piti.java.hoteltesting.exception.ResourceNotFoundException;
import com.piti.java.hoteltesting.mapper.LocationMapper;
import com.piti.java.hoteltesting.model.Location;
import com.piti.java.hoteltesting.repository.LocationRepository;
import com.piti.java.hoteltesting.service.LocationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService{
	private LocationRepository locationRepository;

	@Override
	public LocationDTO save(LocationDTO locationDTO) {
		Location location = LocationMapper.INSTANCE.toEntity(locationDTO);
		location = locationRepository.save(location);
		return LocationMapper.INSTANCE.toDTO(location);
	}

	@Override
	public Location getById(Long id) {
		return locationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Location", "id", id, HttpStatus.NOT_FOUND));
	}
}
