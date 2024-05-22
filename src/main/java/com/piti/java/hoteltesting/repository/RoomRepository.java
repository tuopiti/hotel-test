package com.piti.java.hoteltesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piti.java.hoteltesting.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
