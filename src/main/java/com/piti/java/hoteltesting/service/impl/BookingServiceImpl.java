package com.piti.java.hoteltesting.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.piti.java.hoteltesting.dto.BookingDTO;
import com.piti.java.hoteltesting.dto.RoomBookingDTO;
import com.piti.java.hoteltesting.mapper.BookingMapper;
import com.piti.java.hoteltesting.model.Booking;
import com.piti.java.hoteltesting.model.BookingDetail;
import com.piti.java.hoteltesting.model.Room;
import com.piti.java.hoteltesting.repository.BookingDetailRepository;
import com.piti.java.hoteltesting.repository.BookingRepository;
import com.piti.java.hoteltesting.repository.RoomRepository;
import com.piti.java.hoteltesting.service.BookingService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService{
	private BookingRepository bookingRepository;
	private BookingDetailRepository bookingDetailRepository;
	private RoomRepository roomRepository;
	private BookingMapper bookingMapper;

	@Override
	public void booking(BookingDTO bookingDTO) {
		List<RoomBookingDTO> roomBookingDTOs = bookingDTO.getRooms();
		
		List<Long> roomIds = roomBookingDTOs.stream()
				.map(RoomBookingDTO::getRoomId)
				.toList();
		
		Map<Long, Room> roomMap = roomRepository.findAllById(roomIds)
				.stream()
				.collect(Collectors.toMap(Room::getId, Function.identity()));

		//save booking
		Booking booking = bookingMapper.toBooking(bookingDTO);
		bookingRepository.save(booking);
		
		
		//save booking details
		for (RoomBookingDTO bookingDTOs : roomBookingDTOs) {
			Room room = roomMap.get(bookingDTOs.getRoomId());
			BookingDetail bookingDetail = bookingMapper.toBookingDetail(bookingDTOs, booking, room.getRoomPrice());			
			bookingDetailRepository.save(bookingDetail);
		}
		
	}

}
