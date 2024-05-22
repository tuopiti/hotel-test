package com.piti.java.hoteltesting.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDTO {
	private Long id;
	private Integer roomNumber;
	private String roomType;
	private BigDecimal roomPrice;
	private boolean availability;
}
