package com.piti.java.hoteltesting.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.piti.java.hoteltesting.dto.RoomDTO;
import com.piti.java.hoteltesting.exception.ResourceNotFoundException;
import com.piti.java.hoteltesting.mapper.RoomMapper;
import com.piti.java.hoteltesting.model.Room;
import com.piti.java.hoteltesting.repository.RoomRepository;
import com.piti.java.hoteltesting.service.RoomService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService{
	private RoomRepository roomRepository;
	private RoomMapper roomMapper;

	@Override
	public RoomDTO save(RoomDTO roomDTO) {
		Room room = roomMapper.toEntity(roomDTO);
		room = roomRepository.save(room);
		return roomMapper.toDTO(room);
	}

	@Override
	public Room getById(Long id) {
		return roomRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Room", "id", id, HttpStatus.NOT_FOUND));
	}

}
