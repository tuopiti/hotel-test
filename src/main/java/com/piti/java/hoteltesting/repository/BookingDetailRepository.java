package com.piti.java.hoteltesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piti.java.hoteltesting.model.BookingDetail;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, Long>{

}
