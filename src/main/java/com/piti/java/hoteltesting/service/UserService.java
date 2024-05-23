package com.piti.java.hoteltesting.service;

import java.util.List;

import com.piti.java.hoteltesting.dto.UserDTO;
import com.piti.java.hoteltesting.model.User;

public interface UserService {

	String createUser(UserDTO userDTO);
	User getUserById(Long id);
	List<UserDTO> getAllUser();
	
}
