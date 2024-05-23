package com.piti.java.hoteltesting.mapper;

import org.mapstruct.Mapper;

import com.piti.java.hoteltesting.dto.UserDTO;
import com.piti.java.hoteltesting.model.User;

@Mapper(uses = RoleMapper.class)
public interface UserMapper {
	
	User toEntity(UserDTO userDTO);
	UserDTO toDto(User user);
	
}
