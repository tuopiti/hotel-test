package com.piti.java.hoteltesting.mapper;

import java.math.BigDecimal;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.piti.java.hoteltesting.dto.BookingDTO;
import com.piti.java.hoteltesting.dto.RoomBookingDTO;
import com.piti.java.hoteltesting.model.Booking;
import com.piti.java.hoteltesting.model.BookingDetail;
import com.piti.java.hoteltesting.service.RoomService;

@Mapper(componentModel = "spring", uses = {RoomService.class})
public interface BookingMapper {
	Booking toBooking(BookingDTO dto);
	
	@Mapping(target = "booking", source = "booking")
	@Mapping(target = "room", source = "dto.roomId")
	@Mapping(target = "id", ignore = true)
	BookingDetail toBookingDetail(RoomBookingDTO dto, Booking booking, BigDecimal totalPrice);
}
