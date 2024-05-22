package com.piti.java.hoteltesting.service;

import com.piti.java.hoteltesting.dto.RoomDTO;
import com.piti.java.hoteltesting.model.Room;

public interface RoomService {
	RoomDTO save(RoomDTO roomDTO);
	Room getById(Long id);
}
