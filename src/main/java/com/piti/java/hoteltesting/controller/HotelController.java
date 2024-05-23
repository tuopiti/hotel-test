package com.piti.java.hoteltesting.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piti.java.hoteltesting.dto.HotelDTO;
import com.piti.java.hoteltesting.mapper.HotelMapper;
import com.piti.java.hoteltesting.model.Hotel;
import com.piti.java.hoteltesting.service.HotelService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/hotel")
@AllArgsConstructor
public class HotelController {
	private HotelService hotelService;
	private HotelMapper hotelMapper;
	
	@PostMapping
	public ResponseEntity<HotelDTO> create(@RequestBody HotelDTO hotelDTO){
		HotelDTO dto = hotelService.save(hotelDTO);
		return new ResponseEntity<HotelDTO>(dto, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<HotelDTO> getHotelById(@PathVariable("id") Long id){
		Hotel hotel = hotelService.getById(id);
		return ResponseEntity.ok(hotelMapper.toDTO(hotel));
	}

}
