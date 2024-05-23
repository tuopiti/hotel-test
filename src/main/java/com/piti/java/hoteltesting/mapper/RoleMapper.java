package com.piti.java.hoteltesting.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.piti.java.hoteltesting.model.Role;

@Mapper
public abstract class RoleMapper {
	public static final RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
	
	 public Long roleToRoleId(Role role) {
	     return role.getId();
	 }
	 
	 public abstract Role roleIdToRole(Long roleId);
}
