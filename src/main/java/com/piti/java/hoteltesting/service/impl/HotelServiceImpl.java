package com.piti.java.hoteltesting.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.piti.java.hoteltesting.dto.HotelDTO;
import com.piti.java.hoteltesting.exception.ResourceNotFoundException;
import com.piti.java.hoteltesting.mapper.HotelMapper;
import com.piti.java.hoteltesting.model.Hotel;
import com.piti.java.hoteltesting.repository.HotelRepository;
import com.piti.java.hoteltesting.service.HotelService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService{
	private HotelRepository hotelRepository;
	private HotelMapper hotelMapper;
	
	@Override
	public HotelDTO save(HotelDTO hotelDTO) {
		Hotel hotel = hotelMapper.toEntity(hotelDTO);
		hotel = hotelRepository.save(hotel);
		return hotelMapper.toDTO(hotel);
	}
	
	
	@Override
	public Hotel getById(Long id) {
		return hotelRepository.findById(id)
				.orElseThrow(()  -> new ResourceNotFoundException("Hotel", "id", id,HttpStatus.NOT_FOUND));
	}
}
