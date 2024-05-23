package com.piti.java.hoteltesting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piti.java.hoteltesting.dto.LocationDTO;
import com.piti.java.hoteltesting.mapper.LocationMapper;
import com.piti.java.hoteltesting.model.Location;
import com.piti.java.hoteltesting.service.LocationService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/location")
@AllArgsConstructor
public class LocationController {
	private LocationService locationService;
	
	@PostMapping
	public ResponseEntity<LocationDTO> create(@RequestBody @Valid LocationDTO locationDTO){
		LocationDTO dto = locationService.save(locationDTO);
		return new ResponseEntity<LocationDTO>(dto, HttpStatus.CREATED);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<LocationDTO> getById(@PathVariable("id") long id){
		Location location = locationService.getById(id);
		LocationDTO locationDTO = LocationMapper.INSTANCE.toDTO(location);
		return new ResponseEntity<>(locationDTO, HttpStatus.OK);	
	}
}
