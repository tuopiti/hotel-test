package com.piti.java.hoteltesting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBookingDTO {
	private Long roomId;
    private Integer numberOfGuest;
}
