package com.piti.java.hoteltesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piti.java.hoteltesting.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
