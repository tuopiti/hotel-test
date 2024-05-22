package com.piti.java.hoteltesting.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piti.java.hoteltesting.dto.BookingDTO;
import com.piti.java.hoteltesting.service.BookingService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/booking")
@AllArgsConstructor
public class BookingController {
	private BookingService bookingService;
	
	@PostMapping
    public ResponseEntity<?> create(@RequestBody BookingDTO bookingDTO) {        
        bookingService.booking(bookingDTO);
        return ResponseEntity.ok().build();
    }
}
