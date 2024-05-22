package com.piti.java.hoteltesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piti.java.hoteltesting.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{
	
}
