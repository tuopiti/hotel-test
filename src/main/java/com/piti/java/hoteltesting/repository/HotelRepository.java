package com.piti.java.hoteltesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piti.java.hoteltesting.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
