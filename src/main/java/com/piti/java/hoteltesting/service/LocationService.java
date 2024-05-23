package com.piti.java.hoteltesting.service;

import com.piti.java.hoteltesting.dto.LocationDTO;
import com.piti.java.hoteltesting.model.Location;

public interface LocationService {
	LocationDTO save(LocationDTO locationDTO);
	Location getById(Long id);
}
