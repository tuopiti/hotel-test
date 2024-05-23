package com.piti.java.hoteltesting.service;

import com.piti.java.hoteltesting.dto.LoginDTO;
import com.piti.java.hoteltesting.dto.RegisterDTO;

public interface AuthService {
	
	String register(RegisterDTO registerDTO);
	
	String login(LoginDTO loginDto);
}
