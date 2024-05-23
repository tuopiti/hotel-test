package com.piti.java.hoteltesting.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.piti.java.hoteltesting.dto.UserDTO;
import com.piti.java.hoteltesting.exception.ResourceNotFoundException;
import com.piti.java.hoteltesting.mapper.UserMapper;
import com.piti.java.hoteltesting.model.Role;
import com.piti.java.hoteltesting.model.User;
import com.piti.java.hoteltesting.repository.RoleRepository;
import com.piti.java.hoteltesting.repository.UserRepository;
import com.piti.java.hoteltesting.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
	private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String createUser(UserDTO userDTO) {

		Set<Role> roles = new HashSet<>();
        for (String roleId : userDTO.getRoles()) {
            Role role = roleRepository.findById(Long.parseLong(roleId))
                                      .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));
            roles.add(role);
        }
        
        // Create User entity and set roles
        User user = new User();
        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRoles(roles);
        userRepository.save(user);
        
		return "User created successfully";
	}
	
	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", id, HttpStatus.NOT_FOUND));
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<User> users = userRepository.findAll();
		return users.stream()
				    .map((u) -> userMapper.toDto(u))
				    .collect(Collectors.toList());
	}
}
