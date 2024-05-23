package com.piti.java.hoteltesting.config.security.jwt;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.piti.java.hoteltesting.model.Role;
import com.piti.java.hoteltesting.model.User;
import com.piti.java.hoteltesting.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		 User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
	                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));

		    Set<SimpleGrantedAuthority> authorities = user.getRoles()
					.stream()
					.flatMap(role -> toStreamOfSimpleGrantedAuthority(role))
					.collect(Collectors.toSet());

		    /*
	        return new org.springframework.security.core.userdetails.User(
	                usernameOrEmail,
	                user.getPassword(),
	                authorities
	        );
	        */
		    
		  return new CustomUserDetails(user.getId(), user.getUsername(), user.getPassword(), authorities);
	}
	
	
	private Stream<SimpleGrantedAuthority> toStreamOfSimpleGrantedAuthority(Role role){
		Set<SimpleGrantedAuthority> permissions = role.getPermissions().stream()
				.map(p -> new SimpleGrantedAuthority(p.getName()))
				.collect(Collectors.toSet());
			permissions.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
			return permissions.stream();
	}

}
