package com.piti.java.hoteltesting.service;

import com.piti.java.hoteltesting.dto.HotelDTO;
import com.piti.java.hoteltesting.model.Hotel;

public interface HotelService {
	HotelDTO save(HotelDTO hotelDTO);
	Hotel getById(Long id);
}
